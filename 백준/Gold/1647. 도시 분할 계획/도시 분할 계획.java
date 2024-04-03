import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int[] p;
	static int[] result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] edges = new int[M][3];
		p = new int[N + 1];
		result = new int[N-1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			edges[i][0] = Integer.parseInt(st.nextToken());
			edges[i][1] = Integer.parseInt(st.nextToken());
			edges[i][2] = Integer.parseInt(st.nextToken());
			

		}

		Arrays.sort(edges, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[2] - o2[2];
			}
		});
		
		for(int i = 0 ; i < N; i++) {
			makeSet(i);
		}
		int pick = 0;
		int ans = 0;
		for(int i = 0 ; i < M ; i++) {
			if(findSet(edges[i][0])!=findSet(edges[i][1])) {
				union(edges[i][0],edges[i][1]);

				ans += edges[i][2];
				result[pick++] = edges[i][2]; 
			}
			
			if(pick == N-1) 
				break;
		}
		int max = 0 ; 
		int idx = -1;
		for(int i = 0 ; i < result.length ; i++) {
			if(max < result[i]) {
				max = result[i];
				idx = i;
			}
		}
		
		System.out.println(ans-result[idx]);
		
		
	}

	static void makeSet(int v) {
		p[v] = v;
	}

	static int findSet(int v) {
		if (v != p[v]) {
			p[v] = findSet(p[v]);
		}
		return p[v];
	}

	static void union(int k, int v) {
		p[findSet(v)] = findSet(k);
	}
}