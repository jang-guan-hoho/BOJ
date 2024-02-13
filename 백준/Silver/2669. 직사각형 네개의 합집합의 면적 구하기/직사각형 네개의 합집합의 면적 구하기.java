import java.util.Scanner;

public class Main {
	static int[][] map = new int[101][101];
	static void color(int[] min,int[] max) {
		for(int r=min[1];r<max[1];r++) {
			for(int c=min[0];c<max[0];c++) {
				map[r][c]=1;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt =0;
		for(int i=0; i<4;i++) {
			int[] min = {sc.nextInt(), sc.nextInt()};
			int[] max = {sc.nextInt(), sc.nextInt()};
			color(min,max);
		}
		for(int r=0;r<101;r++) {
			for(int c=0;c<101;c++) {
				if(map[r][c]==1)
					cnt++;
			}
		}
		System.out.println(cnt);
	}
}