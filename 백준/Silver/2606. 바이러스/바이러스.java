import java.util.Scanner;

public class Main {
	static int V; // 노드 개수
	static boolean[] visited;
	static int[][] adj;
	static int E; // 간선 개수
	static int cnt; // 카운트
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		visited = new boolean[V+1];// 1번부터 노드가 시작 되기 때문에 V+1
		adj = new int[V+1][V+1];
		E = sc.nextInt();
		cnt = 0;
		
		for(int i = 0 ; i< E ;i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			adj[st][ed] = adj[ed][st] = 1; // 무향 그래프
		}
		// 간선 정보 입력 완료
		
		DFS(1);
		System.out.println(cnt);
		
	}


	private static void DFS(int v) {
		// TODO Auto-generated method stub
		visited[v] = true;
		for(int i = 1 ; i < V+1 ; i++) {
			if(adj[v][i]==1&&!visited[i]) {
				visited[i] = true;
				cnt++;
				DFS(i);
			}
		}
		
	}
}