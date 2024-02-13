import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ans = 0;
		int cnt = Integer.MAX_VALUE;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(j*5+i*3==n&&j+i<cnt) {
					cnt = j+i;
					ans = cnt;
				}
			}
		}
		if(ans==0) ans--;
		System.out.println(ans);
	}
}