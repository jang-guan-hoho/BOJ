import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		Queue<Integer> que = new LinkedList<>();

		int N = Integer.parseInt(st.nextToken());
		List<Integer>[] list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		int[] p = new int[N + 1];
		p[1] = 1;
		que.add(1);
		while (!que.isEmpty()) {
			int tmp = que.poll();
			for (int a : list[tmp]) {
				if (p[a] == 0) {
					p[a] = tmp;
					que.add(a);
				}
			}
		}

		for (int i = 2; i <= N; i++) {
			sb.append(p[i] + "\n");
		}
		sb.deleteCharAt(sb.length() - 1);
		System.out.println(sb);
	}
}