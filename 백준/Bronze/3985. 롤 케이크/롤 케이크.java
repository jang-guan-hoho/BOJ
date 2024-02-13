
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		int[] cake = new int[l];
		int[] cnt = new int[l+1];
		int n = sc.nextInt();
		int[][] ans = new int[n][2];
		int max = Integer.MIN_VALUE;
		int ans1 =0;
		for(int i=0;i<n;i++) {
			ans[i][0]=sc.nextInt();
			ans[i][1]=sc.nextInt();
			if(ans[i][1]-ans[i][0]>max) {
				max=ans[i][1]-ans[i][0];
				ans1=i+1;
			}
		}
		for(int i=n-1;i>=0;i--) {
			for(int j=ans[i][0]-1;j<=ans[i][1]-1;j++) {
				cake[j]=i+1;
			}
		}
		for(int i=0;i<l;i++) {
			if(cake[i]!=0)
			cnt[cake[i]]++;
		}
		max = Integer.MIN_VALUE;
		int ans2 =0;
		for(int i=0;i<l+1;i++) {
			if(max<cnt[i]) {
				max = cnt[i];
				ans2=i;
			}
		}
		System.out.println(ans1);
		System.out.println(ans2);
	}
}
