import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int num = sc.nextInt();
		int [] cd = new int[n];
		int min = Integer.MAX_VALUE;
		int ans=0;
		for(int i=0;i<n;i++) {
			cd[i]=sc.nextInt();
		}
		for(int i=0;i<n-2;i++) {
			for(int j=i+1;j<n;j++) {
				for(int c=j+1;c<n;c++) {
					int total = cd[i]+cd[j]+cd[c];
					if(total<=num) {
						total = num-total;
						if(total<min) {
							min = total;
							ans = cd[i]+cd[j]+cd[c];
						}
					}
				}
			}
		}
		System.out.println(ans);
	}
}