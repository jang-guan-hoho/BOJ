package 알고리즘공부;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 버블정렬2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(sc.readLine());
		int [] arr = new int [N];
		int [] cmp = new int [N];
		int ans = 0;
		int temp=0;
		StringTokenizer st = new StringTokenizer(sc.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(sc.readLine());
		for(int i=0;i<N;i++) {
			cmp[i]=Integer.parseInt(st.nextToken());
		}
		if(Arrays.equals(arr, cmp)) {
			// Arrays.equals(a,b);
			ans=1;
		}
		else {
			exit_:
			for(int i=N-1;i>=0;i--) {
				for(int j=0;j<i;j++) {
					if(arr[j]>arr[j+1]) {
						temp=arr[j+1];
						arr[j+1]=arr[j];
						arr[j]=temp;
					}
					if(Arrays.equals(arr, cmp)) {
						// Arrays.equals(a,b);
						ans=1;
						break exit_;
					}
				}
				if(temp==0)
					break;
			}
		}
		bw.write(String.valueOf(ans));
		bw.flush();
	}
}
