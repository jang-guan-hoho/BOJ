import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class  Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int t=0;t<T;t++) {
			int cnt=0;
			int sum=0;
			String s = bf.readLine();
			for(int i=0;i<s.length();i++) {
				char c = s.charAt(i);
				if(c=='O') {
					sum+=++cnt;
				}else {
					cnt=0;
				}
			}
			System.out.println(sum);
		}
	}
}