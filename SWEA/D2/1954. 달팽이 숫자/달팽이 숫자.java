import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			int N =sc.nextInt();
			int cnt=0;
			int[][] map = new int [N][N];
			int i =0;
			while( cnt<N*N-1) {
				for(int c=i;c<N-1-i;c++) {
					map[i][c]=++cnt;
				}
				for(int r=i;r<N-1-i;r++) {
					map[r][N-1-i]=++cnt;
				}
				for(int c=N-1-i;c>i;c--) {
					map[N-1-i][c]=++cnt;
				}
				for(int r=N-1-i;r>i;r--) {
					map[r][i]=++cnt;
				}
				i++;
			}
			if(map[N/2][N/2]==0) {
				map[N/2][N/2]=++cnt;
			}
			System.out.print("#"+t);
			for(int r=0;r<N;r++) {
				System.out.println();
				for(int c=0;c<N;c++) {
					System.out.print(map[r][c]+" ");
				}
			}
			System.out.println();
		}
	}
}