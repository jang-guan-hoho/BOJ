import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		if (N == M)
			System.out.println(1);
		else if(M==0)
		{
			System.out.println(1);
		}
		else {
			int ans = 1;
			int ams = 1;
			int sub = N-M;
			while (N > M) {
				ans *= N;
				N--;
			}
			while(sub>0) {
				ams *= sub;
				sub--;
			}
			System.out.println(ans/ams);
		}
	}
}