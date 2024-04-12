import java.util.Scanner;

public class Main {
	static 	int[][] map = new int[3][2];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 2; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		
		if(ccw()==0) {
			System.out.println(0);
		}
		else if(ccw() >0) {
			System.out.println(1);
		}
		else { 
			System.out.println(-1);
		}
	}
	static int ccw() {
		return (map[1][0]-map[0][0])*(map[2][1]-map[0][1])-(map[2][0]-map[0][0])*(map[1][1]-map[0][1]);
	}
	
}