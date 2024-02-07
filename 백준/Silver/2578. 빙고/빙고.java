import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int [5][5];
		int[] ans = new int[25];
		int cnt =0;
		int bingo=0;
		for(int r=0;r<5;r++) {
			for(int c=0;c<5;c++) {
				arr[r][c]=sc.nextInt();
			}
		}
		for(int i=0;i<25;i++) {
			ans[i]= sc.nextInt();
		}
		for(;cnt<25;cnt++) {
			bingo=0;
		for(int r=0;r<5;r++) {
			for(int c=0;c<5;c++) {
				if(ans[cnt]==arr[r][c]) {
					arr[r][c]=0;
				}
			}
		}
		for(int r=0;r<5;r++) {
			if(arr[r][0]==0&&arr[r][1]==0&&arr[r][2]==0&&arr[r][3]==0&&arr[r][4]==0) {
				bingo++;
			}
		}
		for(int c=0;c<5;c++) {
			if(arr[0][c]==0&&arr[1][c]==0&&arr[2][c]==0&&arr[3][c]==0&&arr[4][c]==0) {
				bingo++;
			}
		}
		if(arr[0][0]==0&&arr[1][1]==0&&arr[2][2]==0&&arr[3][3]==0&&arr[4][4]==0) {
			bingo++;
		}
		if(arr[0][4]==0&&arr[1][3]==0&&arr[2][2]==0&&arr[3][1]==0&&arr[4][0]==0) {
			bingo++;
		}
		if(bingo>=3)
			break;
		}
		System.out.println(cnt+1);
	}
}
