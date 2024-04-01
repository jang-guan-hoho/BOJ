import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static boolean[][][] visited; // [벽을 부수었는지 여부][행][열]
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class Point {
        int row;
        int col;
        int distance;
        int wallBreaks; // 부순 벽의 개수

        public Point(int row, int col, int distance, int wallBreaks) {
            this.row = row;
            this.col = col;
            this.distance = distance;
            this.wallBreaks = wallBreaks;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[2][N][M];

        // 맵 입력
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(BFS());
    }

    static int BFS() {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0, 1, 0)); // 시작점을 큐에 추가
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            // 도착점에 도달한 경우 거리 반환
            if (current.row == N - 1 && current.col == M - 1)
                return current.distance;

            // 상하좌우 이동
            for (int i = 0; i < 4; i++) {
                int nr = current.row + dr[i];
                int nc = current.col + dc[i];

                // 범위 체크
                if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    // 벽이 아닌 경우
                    if (map[nr][nc] == 0) {
                        if (!visited[current.wallBreaks][nr][nc]) {
                            visited[current.wallBreaks][nr][nc] = true;
                            queue.offer(new Point(nr, nc, current.distance + 1, current.wallBreaks));
                        }
                    }
                    // 벽인 경우
                    else {
                        // 벽을 부순 적이 없고 아직 벽을 부수지 않은 경우
                        if (current.wallBreaks == 0 && !visited[1][nr][nc]) {
                            visited[1][nr][nc] = true;
                            queue.offer(new Point(nr, nc, current.distance + 1, 1));
                        }
                    }
                }
            }
        }

        // 도착점에 도달할 수 없는 경우
        return -1;
    }
}