package 알고리즘공부;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 참외밭 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		int [][]map = new int [12][2];
		int [] cnt = new int[4];
		for(int r=0;r<6;r++) {
			String s = bf.readLine();
			StringTokenizer st = new StringTokenizer(s);
			for(int c=0;c<2;c++) {
				map[r][c]= Integer.parseInt(st.nextToken());
				map[r+6][c]= map[r][c];
			}
		}
		for(int r=0;r<12;r++) {
			for(int i=0;i<4;i++) {
				if(map[r][0]==(i+1))
					cnt[i]++;
			}
		}
		int max=1;
		int min=1;
		for(int r=0;r<6;r++) {
			if(cnt[map[r][0]-1]==2)
				max*=map[r][1];
		}
		//농장 큰거끼리더한거
		for(int r=1;r<10;r++) {
			if(cnt[map[r][0]-1]==4&&cnt[map[r-1][0]-1]!=2&&cnt[map[r+2][0]-1]==4)
				min=map[r][1]*map[r+1][1];
		}
		
		System.out.println((max-min)*N);
		
		
		
	}
}
