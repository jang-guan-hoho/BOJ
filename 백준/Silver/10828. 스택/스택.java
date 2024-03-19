import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] stack;
	static int idx = -1;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		stack = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
			case "push": {
				push(Integer.parseInt(st.nextToken()));
				break;
			}
			case "pop":{
				System.out.println(pop());
				break;
			}
			case "size":{
				System.out.println(size());
				break;
			}
			case "empty":{
				System.out.println(empty());
				break;
			}
			case "top":{
				System.out.println(top());
				break;
			}
			}
		}
	}

	private static int top() {
		if(idx>=0)
			return stack[idx];
		else
			return -1;
	}

	private static int empty() {
		if(idx < 0) {
			return 1;
		}else
			return 0;
	}

	private static int size() {
		if(idx>=0)
			return idx+1;
		else
			return 0;
	}

	private static int pop() {
		if(idx >=0)
			return stack[idx--];
		else
			return -1;
	}

	public static void push(int num) {
		stack[++idx]=num;
	}
	
}
