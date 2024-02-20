import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] house;
	static int[][] cost;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		house = new int[N][3];
		 cost = new int[N][3];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			house[i][0]= Integer.parseInt(st.nextToken());
			house[i][1]= Integer.parseInt(st.nextToken());
			house[i][2]= Integer.parseInt(st.nextToken());
		}
		cost[0][0] = house[0][0];
		cost[0][1] = house[0][1];
		cost[0][2] = house[0][2];
		System.out.println(Math.min(Math.min(rgb(N-1, 0), rgb(N-1, 1)), rgb(N-1, 2)));
	}
	
	static int rgb(int i, int color) {
		if(cost[i][color]==0) {
			if(color == 0)
				return cost[i][color] = Math.min(rgb(i-1,1), rgb(i-1,2))+house[i][color];
			else if(color == 1)
				return cost[i][color] = Math.min(rgb(i-1,0), rgb(i-1,2))+house[i][color];
			else
				return cost[i][color] = Math.min(rgb(i-1,1), rgb(i-1,0))+house[i][color];
			}
		
		return cost[i][color];
	}
}