import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] card;
	static int[] num;
	static int[] ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		card = new int[N];
		for (int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		num = new int[M];
		ans = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(card);
		for (int i = 0; i < M; i++) {
			search(i, 0, N-1);
		}
		for(int i = 0 ; i < M ; i++) {
			sb.append(ans[i]+" ");
		}
		System.out.println(sb);
	}
// 이진탐색
	static void search(int idx, int st, int ed) {
		int target = num[idx];
		if (st > ed) {
			return;
		}

		int mid = (st + ed) / 2 ;

		if (target == card[mid]) {
			ans[idx] = 1;
			return;
		} else if (target > card[mid]) {
			search(idx, mid+1, ed);
		} else {
			search(idx, st, mid-1);
		}
	}
}
