import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static int[] counting_sort(int[] arr) {
		int l =max(arr);
		int[] cnt = new int [l];
		int[] ans= new int [arr.length];
		for(int i=0;i<arr.length;i++) {
			cnt[arr[i]]++;
		}
		for(int i=0;i<cnt.length-1;i++) {
			cnt[i+1]+=cnt[i];
		}
		for(int i=0;i<arr.length;i++) {
			ans[--cnt[arr[i]]]=arr[i]; //이게 핵심
		}
		return ans;
	}
	public static Integer max(int[] arr) {
		int max=Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++) {
			if(max<arr[i])
				max=arr[i];
		}
		return max+1;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(bf.readLine());
		
		int[] arr = new int [n];
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(bf.readLine());
		}
		arr=counting_sort(arr);
		for(int i=0;i<n;i++) {
			sb.append(arr[i]).append("\n");
		}
		System.out.println(sb);
	}
}