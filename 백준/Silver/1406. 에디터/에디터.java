import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static Stack<Character> str = new Stack<>();
	static Stack<Character> copy = new Stack<>();
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		String s = st.nextToken();
		N = s.length();
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			char c= s.charAt(i);
			str.add(c);
		}
		int M = Integer.parseInt(st.nextToken());
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			String action = st.nextToken();
			switch(action) {
			case "L" :
				left();
				break;
			case "D" :
				right();
				break;
			case "B" :
				delete();
				break;
			case "P" :
				char msg = st.nextToken().charAt(0);
				plus(msg);
				break;
			}
		}
		while(!str.isEmpty()) {
			copy.add(str.pop());
		}
		char[] ch = new char[copy.size()];
		int i=0;
		for(char c : copy) {
			ch[i++] = c;
		}
		for(int j=ch.length-1; j>=0;j--) {
			sb.append(ch[j]);
		}
		System.out.println(sb);
	}
	
	
	
	
	private static void plus(char msg) {
		str.add(msg);
	}
	private static void delete() {
		if(!str.isEmpty())
			str.pop();
	}
	private static void right() {
		if(!copy.isEmpty())
			str.add(copy.pop());
	}
	private static void left() {
		if(!str.isEmpty())
			copy.add(str.pop());
	}
}
