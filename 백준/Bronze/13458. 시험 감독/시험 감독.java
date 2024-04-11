import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] map = new int[N];
		for (int i = 0; i < N; i++)
			map[i] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		long ans = N;

		for (int i = 0; i < N; i++) {
			int num = map[i] - B;
			if (num > 0) {
				if (num % C != 0) {
					ans = ans + num / C + 1;
				} else {
					ans = ans + num / C;
				}
			}
		}
		System.out.println(ans);

	}
}