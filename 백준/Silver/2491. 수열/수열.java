
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static int[] up(int[] arr) {
		int cnt=0;
		int[] ans=new int[arr.length+1];
		for(int i=0;i<arr.length-1;i++) {
			if(arr[i]<=arr[i+1]) {
				ans[i]=++cnt;
			}
			else {
				ans[i]=++cnt;
				cnt=0;
			}
		}
		if(ans[arr.length-2]!=0)
			ans[arr.length-1]=++cnt;
		else
			ans[arr.length-1]=0;
		return ans;
	}
	public static int[] down(int[] arr) {
		int cnt=0;
		int[] ans=new int[arr.length+1];
		for(int i=0;i<arr.length-1;i++) {
			if(arr[i]>=arr[i+1]) {
				ans[i]=++cnt;
			}
			else {
				ans[i]=++cnt;
				cnt=0;
			}
		}
		if(ans[arr.length-2]!=0)
			ans[arr.length-1]=++cnt;
		else
			ans[arr.length-1]=0;
		return ans;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(bf.readLine());
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N+1];
		int[] up = new int[N+1];
		int[] down = new int[N+1];
		int max = Integer.MIN_VALUE;
//		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=sc.nextInt();
		}
		up=up(arr);
		down=down(arr);
		for(int i=0;i<N;i++) {
			if(max<up[i]) {
				max = up[i];
			}
			if(down[i]>max) {
				max = down[i];
			}
		}
		System.out.println(max);
	}
}


