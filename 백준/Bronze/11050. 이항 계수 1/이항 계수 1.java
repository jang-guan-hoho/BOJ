import java.util.Scanner;

public class Main {
	static long memo[][] = new long[200][200];
	static long bc_memo(int n, int r) {	
		if (memo[n][r] > 0)
			return memo[n][r]; 
		if (n == r || r == 0) 
			return memo[n][r] = 1;	
		else 
			return bc_memo(n - 1, r) + bc_memo(n - 1, r - 1); 
		}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int r = sc.nextInt();	
		System.out.println(bc_memo(n, r));
	}

}