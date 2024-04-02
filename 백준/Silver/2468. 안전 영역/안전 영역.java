import java.util.Arrays;
import java.util.Scanner;
 
public class Main {
    static int[] cnt;
    static int[][] map;
    static int N;
    static final int maxDay = 100;
    static boolean[][] visited;
    static int favor;
    static int st;
    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,-1,1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

            N = sc.nextInt();
            cnt = new int[101];
            map = new int[N + 2][N + 2];// 치즈 주변을 0으로 둘러버릴 예정
            for (int r = 1; r <= N; r++) {
                for (int c = 1; c <= N; c++) {
                    map[r][c] = sc.nextInt();
                }
            }
            for (int i = 0; i <= maxDay; i++) {
                visited = new boolean[N + 2][N + 2];
                favor = i;
                for (int r = 1; r <= N; r++) {
                    for (int c = 1; c <= N; c++) {
                        if (map[r][c] > favor && !visited[r][c]) {
                             
                            DFS(r, c);
                            cnt[i]++;
                        }
//                      for(boolean[] arr : visited) {
//                          System.out.println(Arrays.toString(arr));
//                      }
                    }
                }
            }
            int max = 0;
            for (int x : cnt) {
                if( max < x) {
                    max = x;
                }
        }
            System.out.println(max);
    }
 
    static void DFS(int r, int c) {
        visited[r][c] = true;
        for(int i =0; i<4;i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
        if (!visited[nr][nc] && map[nr][nc] > favor) {
            DFS(nr, nc);
// 미리 봐야한다는것에 주목
        }
        }
    }
 
}