import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int cnt = 0;
	static int index=0;
	public static int[] play(int[] map,int i,int L) {
		if(map[i]%2==1) {
			if(i+L>=map.length) {
				map[i+L-map.length]++;
				index=i+L-map.length;
			}
			else {
				map[i+L]++;
				index=i+L;
			}
		}
		else {
			if(i-L<0) {
				map[map.length-(L-i)]++;
				index = map.length-(L-i);
			}
			else {
				map[i-L]++;
				index = i-L;
			}
		}
		cnt++;
		return map;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] std = new int [N];
		std[index]++;
		while(std[index]!=M) {
			play(std,index,L);
		}
		System.out.println(cnt);
	}
}
