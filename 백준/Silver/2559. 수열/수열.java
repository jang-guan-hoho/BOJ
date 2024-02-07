import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] temp = new int[n];
		int k = sc.nextInt();
		int[] sum = new int[n-k+1];
		int max= Integer.MIN_VALUE;
		for (int i=0;i<n;i++) {
			temp[i]=sc.nextInt();
		}
		for (int i = 0; i < n - k + 1; i++) {
			for (int j = i; j < i+k; j++) {
				sum[i] += temp[j];
			}
		}
		for(int i : sum) {
			if(max<i) {
				max=i;
			}
		}
		System.out.println(max);
	}
}