
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N  = sc.nextInt();
		int M = sc.nextInt();
		Queue<Integer> que = new LinkedList<>();
		for(int i=1;i<=N;i++){
			que.add(i);
		}
		System.out.print("<");
		while(que.size() != 1) {
			for(int i=0;i<M-1;i++) {
				que.add(que.poll());
			}
			System.out.print(que.poll()+", ");
		}

		System.out.print(que.poll()+">");
	}
}
