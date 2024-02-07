import java.util.Scanner;

public class Main {
	static int[][] map = new int [100][100];
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
		for(int r=0;r<100;r++) {
			for(int c=0;c<100;c++) {
				if(map[r][c]==1)
					cnt++;
			}
		}
		System.out.println(cnt);
	}
}