import java.util.Scanner;

public class Main {
	static int[] cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		cnt = new int[N + 1];
		System.out.println(cal(N));
	}

	static int cal(int num) {
		if (cnt[num] == 0&&num>1) {
			if (num % 6 == 0) {
				cnt[num] = Math.min(cal(num - 1), Math.min(cal(num / 2), cal(num / 3))) + 1;
			} else if (num % 3 == 0) {
				cnt[num] = Math.min(cal(num / 3), cal(num - 1)) + 1;
			} else if (num % 2 == 0) {
				cnt[num] = Math.min(cal(num - 1), (cal(num / 2))) + 1;
			} else {
				cnt[num] = cal(num - 1) + 1;
			}
		}

		return cnt[num];
	}
}