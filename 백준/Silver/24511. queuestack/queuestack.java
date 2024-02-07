import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(st.nextToken());
		int[] sta = new int[n];
		int[] data = new int[n];
		Queue<Integer> que = new LinkedList<>();
		st = new StringTokenizer(br.readLine());
 		for (int i = 0; i < n; i++) {
			sta[i] = Integer.parseInt(st.nextToken());
		}
 		st = new StringTokenizer(br.readLine());
		for (int i = 0; i <n; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = n-1; i >=0; i--) {
			if(sta[i]==0)
				que.add(data[i]);
		}
		st= new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			que.add(Integer.parseInt(st.nextToken()));
			bw.write(que.poll()+" ");
		}
		bw.flush();
	}
}