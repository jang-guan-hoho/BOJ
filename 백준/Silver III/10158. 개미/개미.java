import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		StringBuilder sb =new StringBuilder();
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		int[] ant = {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
		int[] d = {1,1};
		int t = Integer.parseInt(bf.readLine());
		ant[0]=(ant[0]+t)%(2*w);
		ant[1]=(ant[1]+t)%(2*h);
		if(ant[0]>w)
			ant[0]=2*w-ant[0];
		if(ant[1]>h)
			ant[1]=2*h-ant[1];
		sb.append(ant[0]).append(" ").append(ant[1]);
		System.out.println(sb);
	}
}