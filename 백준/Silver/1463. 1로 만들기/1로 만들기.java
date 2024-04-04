import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(ccl(N));
    }

    static int ccl(int N) {
        int[] dp = new int[N + 1];
        dp[1] = 0; // 초기값 설정

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1; // 현재 수에서 1을 빼는 경우

            if (i % 2 == 0)
                dp[i] = Math.min(dp[i], dp[i / 2] + 1); // 2로 나누는 경우

            if (i % 3 == 0)
                dp[i] = Math.min(dp[i], dp[i / 3] + 1); // 3으로 나누는 경우
        }

        return dp[N];
    }
}