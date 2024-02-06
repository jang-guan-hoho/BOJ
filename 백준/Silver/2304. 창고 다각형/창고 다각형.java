import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int max = Integer.MIN_VALUE;
		int ans=0;
		int[] gd = new int[N];
		int y_max = Integer.MIN_VALUE;
		Map<Integer, Integer> map = new HashMap<>();
		for(int t=0;t<N;t++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map.put(x, y);
			gd[t]=x;
			if(max<y)
				max=y;
		}
		
		Arrays.sort(gd);
		for(int i=0;i<N;i++) {
			if(map.get(gd[i])==max)
				y_max=gd[i];
		}
		int hgt=gd[0];
		for(int i=0;i<N-1;i++) {
			if(gd[i]<y_max) {
				if(map.get(hgt)<=map.get(gd[i+1])) {
					ans+=map.get(hgt)*(gd[i+1]-hgt);
					hgt=gd[i+1];
				}
			}else break;
		}
		hgt=gd[N-1];
		for(int i=N-1;i>0;i--) {
			if(gd[i]>y_max) {
				if(map.get(hgt)<=map.get(gd[i-1])) {
					ans+=map.get(hgt)*(hgt-gd[i-1]);
					hgt=gd[i-1];
				}
			}else break;
		}
		ans+=max;
		System.out.println(ans);
	}
}