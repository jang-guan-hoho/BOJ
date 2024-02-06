import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a=2;
		int cnt=1;
		if(n==0) cnt=1;
		else {
			while(a<=n) {
				a+=6*cnt;
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}