import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static char[][] map;
    static int N;
    static int M;
    static boolean[][][] visited; // [좌표][좌표][열쇠]
    static Map<Character, Integer> keynumber = new HashMap<>();
    static int str;
    static int stc; // 시작 위치
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class Node {
        int row;
        int col;
        int level;
        List<Character> keys;
        int kn;

        public Node() {
            // TODO Auto-generated constructor stub
        }

        public Node(int row, int col, int level, List<Character> keys, int kn) {
            super();
            this.row = row;
            this.col = col;
            this.level = level;
            this.keys = keys;
            this.kn = kn;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        
        
        keynumber.put(' ', 0);
        keynumber.put('a', 2);
        keynumber.put('b', 2<<1);
        keynumber.put('c', 2<<2);
        keynumber.put('d', 2<<3);
        keynumber.put('e', 2<<4);
        keynumber.put('f', 2<<5);
        
        N = sc.nextInt();
        M = sc.nextInt();
        map = new char[N][M];
        visited = new boolean[N][M][130];

        str = 0;
        stc = 0;

        for (int r = 0; r < N; r++) {
            String s = sc.next();
            for (int c = 0; c < M; c++) {
                map[r][c] = s.charAt(c);
                if (map[r][c] == '0') {
                    str = r;
                    stc = c;
                    map[r][c] = '.';
                }
            }
        }

        System.out.println(BFS());

    }

    private static int BFS() {
        Queue<Node> queue = new LinkedList<>();

        List<Character> keys = new ArrayList<>();
        int kn = keynumber.get(' ');
        queue.add(new Node(str, stc, 0, keys, kn)); // 열쇠 없음

        visited[str][stc][kn] = true;

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
//            System.out.println(curr.row + " " + curr.col+" level : "+curr.level+" keys : "+curr.keys+" visited : "+curr.kn);
            for (int i = 0; i < 4; i++) {
                int nr = curr.row + dr[i];
                int nc = curr.col + dc[i];
                if (nr < N && nr >= 0 && nc < M && nc >= 0 && !visited[nr][nc][curr.kn]) {
                    if (map[nr][nc] == '1'&&!visited[nr][nc][curr.kn]) {
                        return curr.level + 1;
                    } else if (map[nr][nc] != '#') {
                        if (Character.isLowerCase(map[nr][nc]) && !visited[nr][nc][curr.kn]) {
                            // 열쇠를 획득 할 경우
//                            visited = new boolean[N][M]; // 방문 초기화
                            visited[nr][nc][curr.kn] = true;
                            if(!curr.keys.contains(map[nr][nc])) {
                            List<Character> key = new LinkedList<>();
                            key.addAll(curr.keys);
                            key.add(map[nr][nc]);
                            queue.add(new Node(nr, nc, curr.level + 1, key, curr.kn + keynumber.get(map[nr][nc])));
//                            visited[nr][nc][curr.kn] = true;
                            }
                            else {
                            	queue.add(new Node(nr,nc,curr.level+1,curr.keys, curr.kn));
                            }
                        } else if (Character.isUpperCase(map[nr][nc]) && !visited[nr][nc][curr.kn]) {
                            char c = Character.toLowerCase(map[nr][nc]);
                            if (curr.keys.contains(c)) {
                                // 만약 열쇠를 가지고 있다면
//                                map[nr][nc] = '.'; // 문열기 이거 하지 말자 이거 때문에 반례 발생
                                visited[nr][nc][curr.kn] = true;
                                queue.add(new Node(nr, nc, curr.level + 1, curr.keys, curr.kn));
                            }
                        } else if (map[nr][nc]=='.'&&!visited[nr][nc][curr.kn]) {
                            // 그냥 길이면
                            visited[nr][nc][curr.kn] = true;
                            queue.add(new Node(nr, nc, curr.level + 1, curr.keys, curr.kn));
                        }
                    }

                }
            }
        }

        return -1;
    }

}