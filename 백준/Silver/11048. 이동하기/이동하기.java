import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dp = new int[N][M];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (r == 0 && c == 0) {
                    dp[r][c] = map[r][c];
                } else if (r == 0) {
                    dp[r][c] = dp[r][c - 1] + map[r][c];
                } else if (c == 0) {
                    dp[r][c] = dp[r - 1][c] + map[r][c];
                } else {
                    dp[r][c] = Math.max(dp[r - 1][c - 1], Math.max(dp[r][c - 1], dp[r - 1][c])) + map[r][c];
                }
            }
        }

        System.out.println(dp[N - 1][M - 1]);
    }
}