import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static Stack<Character> stack = new Stack<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				String s = st.nextToken();
				method(s);
				System.out.print(" ");
			}
			System.out.println();
		}
	}

	public static void method(String s) {
		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < s.length(); j++) {
			stack.add(s.charAt(j));
		}
		while(stack.size()>0) {
			sb.append(stack.pop());
		}
		System.out.print(sb);
	}

}
