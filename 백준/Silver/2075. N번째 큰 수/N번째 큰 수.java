import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args)throws IOException {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0 ; c < N ; c++) {
				pq.add(Integer.parseInt(st.nextToken()));
			}
		}
		
		int ans = 0;
		
		for(int i = 0 ; i <  N*N-N+1; i++) {
			ans = pq.poll();
		}
		
		System.out.println(ans);
	}
}