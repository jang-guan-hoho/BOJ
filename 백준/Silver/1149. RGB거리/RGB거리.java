import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//RGB거리
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][3];
		int[][] mins = new int[N][3];

		//배열 입력
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}

		//min 배열 입력 (빨강3 최솟값은 빨강3색칠비용+math.min(초록2까지의 비용, 파랑2까지의 비용)
		mins[0][0] = arr[0][0];
		mins[0][1] = arr[0][1];
		mins[0][2] = arr[0][2];
		for (int i = 1; i < N; i++) {
			mins[i][0] = Math.min(mins[i - 1][1], mins[i - 1][2]) + arr[i][0];
			mins[i][1] = Math.min(mins[i - 1][0], mins[i - 1][2]) + arr[i][1];
			mins[i][2] = Math.min(mins[i - 1][1], mins[i - 1][0]) + arr[i][2];
		}
		int[] ans = new int[3];
		for (int i = 0; i < 3; i++) {
			ans[i] = mins[N - 1][i];
		}
		Arrays.sort(ans);
		System.out.println(ans[0]);
	}
}