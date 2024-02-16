import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		int C = sc.nextInt();
		int tgt = sc.nextInt();
		int[][] map = new int[R][C];
		int num = 0;
		int r = 0;
		int c = 0;
		int t = 1;
		boolean result = false;
		end: while (r >= 0 && r < R && c >= 0 && c < C) {
			for (int i = 0; i < C - t; i++) {
				map[r][c++] = ++num;
				if (num == R * C)
					break end;
			}
			for (int i = 0; i < R - t; i++) {
				map[r++][c] = ++num;
				if (num == R * C)
					break end;

			}

			for (int i = 0; i < C - t; i++) {
				map[r][c--] = ++num;
				if (num == R * C)
					break end;

			}
			for (int i = 0; i < R - t; i++) {
				map[r--][c] = ++num;
				if (num == R * C)
					break end;

			}
			r++;
			c++;
			t += 2;

		}

		set: for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == tgt) {
					r = i;
					c = j;
					result = true;
					break set;
				}
			}
		}
		if (result)
			System.out.printf("%d %d", r + 1, c + 1);
		else
			System.out.println(0);
	}
}