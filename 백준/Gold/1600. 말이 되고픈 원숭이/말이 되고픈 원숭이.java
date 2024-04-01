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
    static boolean[][][] visited; // [말행동을 했는지][행][열]
    static int[] hdr = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] hdc = {1, 2, 2, 1, -1, -2, -2, -1}; // 말행동
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[k + 1][N][M]; // 말행동을 했는지에 대한 방문 체크 배열

        // 맵 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(BFS());
    }

    static int BFS() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0, 0}); // 시작점을 큐에 추가 (행, 열, 거리, 말 행동 횟수)
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int distance = current[2];
            int wallBreaks = current[3];

            // 도착점에 도달한 경우 거리 반환
            if (row == N - 1 && col == M - 1)
                return distance;

            // 말의 움직임
            if (wallBreaks < k) { // 말의 움직임을 아직 사용할 수 있는 경우
                for (int i = 0; i < 8; i++) {
                    int nr = row + hdr[i];
                    int nc = col + hdc[i];

                    // 범위 체크
                    if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                        // 벽이 아닌 경우
                        if (map[nr][nc] == 0 && !visited[wallBreaks + 1][nr][nc]) {
                            visited[wallBreaks + 1][nr][nc] = true;
                            queue.offer(new int[]{nr, nc, distance + 1, wallBreaks + 1});
                        }
                    }
                }
            }

            // 원숭이의 움직임
            for (int i = 0; i < 4; i++) {
                int nr = row + dr[i];
                int nc = col + dc[i];

                // 범위 체크
                if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    // 벽이 아닌 경우
                    if (map[nr][nc] == 0 && !visited[wallBreaks][nr][nc]) {
                        visited[wallBreaks][nr][nc] = true;
                        queue.offer(new int[]{nr, nc, distance + 1, wallBreaks});
                    }
                }
            }
        }

        // 도착점에 도달할 수 없는 경우
        return -1;
    }
}