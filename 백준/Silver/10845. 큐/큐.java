
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
	
	static int[] que;
	static int idx=-1;
	static int start =0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		que = new int[N];
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
			case "front":{
				System.out.println(front());
				break;
			}
			case "back":{
				System.out.println(back());
				break;
			}
			}
		}
	}

	private static int back() {
		if(idx>=start) {
			return que[idx];
		}else
			return -1;
	}

	private static int front() {
		if(idx>=start)
			return que[start];
		else
			return -1;
	}

	private static int empty() {
		if(idx < start) {
			return 1;
		}else
			return 0;
	}

	private static int size() {
		if(idx>=start)
			return idx-start+1;
		else
			return 0;
	}

	private static int pop() {
		if(start <=idx)
			return que[start++];
		else
			return -1;
	}

	public static void push(int num) {
		que[++idx]=num;
	}
	
}
