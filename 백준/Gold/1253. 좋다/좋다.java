import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		boolean[] visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int maxnum = arr[N - 1];
		int good = 0;

		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				int now = arr[i] + arr[j];
				if (now > maxnum) {
					continue;
				}

				int mid = N / 2;
				int left = 0;
				int right = N - 1;

				while (left <= right) {
					if (now < arr[mid]) {
						right = mid - 1;
						mid = (left + right) / 2;
					} else if (now > arr[mid]) {
						left = mid + 1;
						mid = (left + right) / 2;
					} else if (now == arr[mid]) {
						if (!visited[mid] && mid!=i && mid!=j) {
							visited[mid] = true;
							good++;
						}
						int midup = mid + 1;
						int middown = mid - 1;
						while (middown >= 0) {
							if (now == arr[middown] && !visited[middown] && middown != i && middown != j) {
								visited[middown] = true;
								good++;
							}
							middown--;
						}
						while (midup < N) {
							if (now == arr[midup] && !visited[midup]&&midup!=i&&midup!=j) {
								visited[midup] = true;
								good++;
							}
							midup++;
						}
						break;
					}
				}
			}
		}

		System.out.println(good);
	}
}