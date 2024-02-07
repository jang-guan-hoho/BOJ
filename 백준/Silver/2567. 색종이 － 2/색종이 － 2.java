import java.util.Scanner;

public class Main {
	static int[][] map = new int [101][101];
	public static void paper(int x,int y) {
		for(int r=x;r<x+10;r++) {
			for(int c=y;c<y+10;c++) {
				map[r][c] = 1;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int cnt=0;
		for(int i=0;i<t;i++) {
			paper(sc.nextInt(), sc.nextInt());
		}
		for(int r=0;r<101;r++) {
			for(int c=0;c<100;c++) {
				if((map[r][c]==0&&map[r][c+1]==1)||(map[r][c]==1&&map[r][c+1]==0)) {
					cnt++;
				}
			}
		}
		for(int c=0;c<101;c++) {
			for(int r=0;r<100;r++) {
				if((map[r+1][c]==0&&map[r][c]==1)||(map[r+1][c]==1&&map[r][c]==0)) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}