import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[][] arr = new int[100][100];

		int N = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			for (int x = 0; x < 10; x++) {
				for (int y = 0; y < 10; y++) {
					arr[X + x - 1][Y + y - 1] += 1;
				}
			}
		}

		int subtract = 0;
		for (int x = 0; x < 100; x++) {
			for (int y = 0; y < 100; y++) {
				if (arr[x][y] > 1) {
					subtract += arr[x][y] - 1;
				}
			}
		}
		System.out.println(100 * N - subtract);

	}
}