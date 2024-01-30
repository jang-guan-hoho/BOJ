package 알고리즘공부;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 카운팅정렬 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(bf.readLine());
		
		int[] ans = new int[N];
		int[] sorted = new int [N];
		int max = Integer.MIN_VALUE;
		for(int i=0;i<N;i++) {
			ans[i]=Integer.parseInt(bf.readLine());
			if(ans[i]>max) {
				max=ans[i];
			}
		}
		int[] count = new int[max+1];
		for(int i=0;i<N;i++)
			count[ans[i]]++;
		for(int i =1; i<max+1; i++) {
			count[i]+=count[i-1];
		}
		for(int i=N-1; i>=0;i--) {
			sorted[--count[ans[i]]]=ans[i]; // 이렇게 특정한 배열의 인덱스값에 접근하는것의 시간복잡도는 O(1)이다.
		}
		
		for(int i=0;i<N;i++) {
			bw.write(String.valueOf(sorted[i]+"\n"));
		}
		bw.flush();
	}
}
