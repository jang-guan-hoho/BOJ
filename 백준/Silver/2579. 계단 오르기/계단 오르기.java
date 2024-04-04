import java.util.Scanner;

public class Main {
    static int[] stair;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        stair = new int[N];
        dp = new int[N];
        
        for (int i = 0; i < N; i++) {
            stair[i] = sc.nextInt();
        }
        
        if (N == 1) {
            System.out.println(stair[0]);
        } else if (N == 2) {
            System.out.println(stair[0] + stair[1]);
        } else {
            dp[0] = stair[0];
            dp[1] = stair[0] + stair[1];
            dp[2] = Math.max(stair[0] + stair[2], stair[1] + stair[2]);

            for (int i = 3; i < N; i++) {
                dp[i] = Math.max(dp[i - 2] + stair[i], dp[i - 3] + stair[i - 1] + stair[i]);
            }
            System.out.println(dp[N - 1]);
        }
    }
}