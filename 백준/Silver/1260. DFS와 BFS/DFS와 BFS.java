import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean[] visited;
	static int[][] map;
	static int N;
	static List<Integer>[] list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];
		visited = new boolean[N+1];
		list = new ArrayList[N+1];
		for(int i=1; i<=N;i++) {
			list[i] = new ArrayList<>();
			
		}
		for(int i= 0 ; i<M;i++) {
			
			st = new StringTokenizer(br.readLine());
			int fr = Integer.parseInt(st.nextToken());
			int ed = Integer.parseInt(st.nextToken());
			
			map[fr][ed] = map[ed][fr] = 1;
			list[fr].add(ed);
			list[ed].add(fr);
			
		}
		for(List<Integer> x : list){
			if(x!=null)
			Collections.sort(x);
		}
		
		dfs(V);
		System.out.println();
		visited = new boolean[N+1];
		bfs(V);
	}

	static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<>();
		visited[v] = true;
		queue.add(v);
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			System.out.print(curr+" ");
			for(int x: list[curr]) {
				if(!visited[x]) {
					queue.add(x);
					visited[x] = true;
				}
			}
		}
		
	}

	static void dfs(int v) {
		visited[v] = true;
		System.out.print(v+" ");
		for(int i = 1 ; i<= N;i++) {
			if(!visited[i]&&map[v][i]==1)
				dfs(i);
		}
	}
	
}