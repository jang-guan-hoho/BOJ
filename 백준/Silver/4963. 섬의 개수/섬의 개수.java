import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static boolean[][] visited;
	static int W, H;
	static int[] dr = {0, 0, -1, 1, 1, 1, -1, -1};
	static int[] dc = {-1, 1, 0, 0, -1, 1, -1, 1};


	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			// 1. 먼저 W,H 입력 받기
			StringTokenizer st = new StringTokenizer(br.readLine());
			W  = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			if(W == 0 && H ==0)
				return;
			
			map = new int [H][W];
			
			for(int r=0;r<H;r++) {
				st = new StringTokenizer(br.readLine());
				for(int c= 0 ; c<W;c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			// 방문 체크 배열 생성
			visited = new boolean[H][W];
			int cnt = 0;
			
			for(int r=0; r<H; r++) {
				for(int c=0; c<W; c++) {
					if(map[r][c] == 1 && !visited[r][c]) {
						cnt++;
						visited[r][c] = true;
						dfs(r,c);
					}
				}
			}
			
			// 그래프 개수 찾기
			// DFS
			// 1. 다시 2차원 행렬을 행 우선 순회
			// 2. 방문하지 않은 노드를 발견하면 (1- 땅)
			//    -> 즉 새로운 그래프를 발견했다면
			// 3. 해당 노드를 기점으로 DFS 탐색 하며 모든 노드 방문 처리
			// 
			
			// DFS는 함수를 호출 해서 system stack을 이용한다
			System.out.println(cnt);
		}
	}


	private static void dfs(int r, int c) {
		// 인접한 8방 탐색을 하며 , 아직 방문하지 않은 연결된 노드가 있다면 탐색 연속
		for(int d=0; d<8;d++) {
		int nr = r + dr[d];
		int nc = c + dc[d];
		if(nr < 0 || nr >= H || nc < 0|| nc >= W)
			continue;
		if(map[nr][nc] == 1 && !visited[nr][nc] ) {
			visited[nr][nc] = true;
			dfs(nr,nc);
		}
		
		}
		
		
		
	}
}