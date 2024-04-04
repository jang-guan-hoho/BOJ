import java.util.Scanner;

public class Main {
	// 조금만 생각해보면 n 을 1과 2로 만드는 경우의 수 문제이다
	// 경우를 조금 생각해보면 n을 만들려면 n-1에서 +1, n-2 에서 +2를한 경우와 똑같다 즉
	// 피보나치 수열이다.

	static long[] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		dp = new long[n + 1];
		
		System.out.println(fibo(n));
	}

	static long fibo(int v) {
		if (v < 3) {
			dp[v] = v;
			return v;
		} else if (dp[v] != 0)
			return dp[v]%10007;
		else {
			dp[v] = (dp[v - 1] + dp[v - 2])%10007;
			return (fibo(v-1)+fibo(v-2))%10007;
		}
	}
}