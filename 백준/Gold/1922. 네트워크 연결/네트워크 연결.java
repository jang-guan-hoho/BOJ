import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	// 시작 노드에서 다른 모든 노드로의 최단 경로를 구하는 문제 즉 크루스칼 알고리즘 문제다

	static int V;
	static int E;
	static int[] p;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		E = Integer.parseInt(st.nextToken());
		p = new int[V+1];


		int[][] edges = new int[E][3];
		int ans = 0;

		for (int i = 0; i < E; i++) {

			st = new StringTokenizer(br.readLine());
			edges[i][0] = Integer.parseInt(st.nextToken());
			edges[i][1] = Integer.parseInt(st.nextToken());
			edges[i][2] = Integer.parseInt(st.nextToken());
		}
		// 크루스칼은 정렬 필요
		Arrays.sort(edges, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[2] - o2[2];
			}
		});
		for(int i = 1 ; i <= V ; i++) {
			makeset(i);
		}
		
		int pick = 0 ; 
		for(int i = 0 ; i < E; i++) {
			if(findSet(edges[i][0]) != findSet(edges[i][1])) {
				union(edges[i][0],edges[i][1]);
				pick++;
				ans += edges[i][2];
			}
			
			if(pick==V-1)
				break;
			
			
		}
		System.out.println(ans);
		
	}
	
	
	static void makeset(int v) {
		p[v] = v;
	}
	
	
	static int findSet(int v) {
		if(v != p[v]) {
			p[v] = findSet(p[v]);
			
		}
		return p[v];
	}
	
	static void union(int k, int v) {
		p[findSet(v)] = findSet(k);
		
		
	}
	
	
	
}