
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] map = new int[1001][1001];
		int n = sc.nextInt();
		int[] cnt = new int[n];
		for (int t = 1; t <= n; t++) {
			int[] a = new int[4];
			a[0] = sc.nextInt();
			a[1] = sc.nextInt();
			a[2] = sc.nextInt();
			a[3] = sc.nextInt();
			for (int r = a[0]; r < a[0]+a[2]; r++) {
				for (int c = a[1]; c <a[1]+a[3]; c++) {
					map[r][c] = t;
				}
			}
		}
		for (int t = 1; t <= n; t++) {
			for (int r = 0; r < 1001; r++) {
				for (int c = 0; c < 1001; c++) {
					if (map[r][c] == t)
						cnt[t-1]++;
				}
			}
			System.out.println(cnt[t-1]);
		}
	}

}
