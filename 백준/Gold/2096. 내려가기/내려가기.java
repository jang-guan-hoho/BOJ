import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][3];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < 3; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] maxScore = new int[N][3];
        int[][] minScore = new int[N][3];

        maxScore[0][0] = minScore[0][0] = map[0][0];
        maxScore[0][1] = minScore[0][1] = map[0][1];
        maxScore[0][2] = minScore[0][2] = map[0][2];

        for (int i = 1; i < N; i++) {
            maxScore[i][0] = Math.max(maxScore[i - 1][0], maxScore[i - 1][1]) + map[i][0];
            minScore[i][0] = Math.min(minScore[i - 1][0], minScore[i - 1][1]) + map[i][0];

            maxScore[i][1] = Math.max(maxScore[i - 1][0], Math.max(maxScore[i - 1][1], maxScore[i - 1][2])) + map[i][1];
            minScore[i][1] = Math.min(minScore[i - 1][0], Math.min(minScore[i - 1][1], minScore[i - 1][2])) + map[i][1];

            maxScore[i][2] = Math.max(maxScore[i - 1][1], maxScore[i - 1][2]) + map[i][2];
            minScore[i][2] = Math.min(minScore[i - 1][1], minScore[i - 1][2]) + map[i][2];
        }

        int maxResult = Math.max(Math.max(maxScore[N - 1][0], maxScore[N - 1][1]), maxScore[N - 1][2]);
        int minResult = Math.min(Math.min(minScore[N - 1][0], minScore[N - 1][1]), minScore[N - 1][2]);

        System.out.println(maxResult + " " + minResult);
    }
}