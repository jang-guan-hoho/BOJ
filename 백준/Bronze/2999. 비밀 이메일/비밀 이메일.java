import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int n = 1;
		int m = s.length()/n;
		int t=0;
		int ans=0;
		while(n<m) {
			if(s.length()%n==0) {
				ans=n;
				m=s.length()/n;
			}
			n++;
		}
		char[][] map = new char[ans][m];
		for(int c=0;c<m;c++) {
			for(int r=0;r<ans;r++) {
				map[r][c]=s.charAt(t++);
			}
		}
		for(int r=0;r<ans;r++) {
			for(int c=0;c<m;c++) {
				System.out.print(map[r][c]);
			}
		}
	}
}