import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int[] counting_sort(int[] arr) {
		int max=Integer.MIN_VALUE;
		int[] ans=new int [arr.length];
		for(int i=0;i<arr.length;i++) {
			if(max<arr[i])
				max=arr[i];
		}
		int[] cnt = new int[max+1];
		for(int i=0; i<arr.length;i++)
			cnt[arr[i]]++;
		for(int i=0;i<cnt.length-1;i++) {
			cnt[i+1]+=cnt[i];
		}
		for(int i=0;i<arr.length;i++) {
			ans[--cnt[arr[i]]]=arr[i];
		}
		return ans;
	}
	
	public static int[] calcu(int[] arr) {
		int[] cnt = new int [2];
		int sum=0;
		for(int i=0;i<arr.length;i++)
			sum+=arr[i];
		exit:
		for(int i=0;i<arr.length-1;i++) {
			for(int j=i+1;j<arr.length;j++) {
				int result=sum;
				result=result-(arr[i]+arr[j]);
				if(result==100) {
					cnt[0]=arr[i];
					cnt[1]=arr[j];
					break exit;
				}
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] arr = new int [9];
		int[] sub = new int [2];
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<9;i++) {
			arr[i]=Integer.parseInt(bf.readLine());
		}
		arr=counting_sort(arr);
		sub=calcu(arr);
		for(int i=0;i<9;i++) {
			if(arr[i]!=sub[0]&&arr[i]!=sub[1])
				sb.append(arr[i]).append("\n");
		}
		System.out.println(sb);
	}
}