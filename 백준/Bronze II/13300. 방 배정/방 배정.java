import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[][]std = new int[6][2];
		int cnt = 0;
		for(int i=0;i<N;i++) {
			int imf = sc.nextInt();
			int grade = sc.nextInt()-1;
			std[grade][imf]++;
		}
		for(int r=0;r<6;r++) {
			for(int c=0;c<2;c++) {
				if(std[r][c]>0) {
					cnt+=(std[r][c]-1)/K+1;
				}
			}
		}
		System.out.println(cnt);
	}
}