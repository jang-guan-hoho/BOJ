import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int ans = 1;
		while(N>0) {
			ans *=N;
			N--;
		}
		System.out.println(ans);
	}
}