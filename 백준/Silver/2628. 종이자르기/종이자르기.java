import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int t = sc.nextInt();
		int[][] cut = new int [t][2];
		List<Integer> row = new ArrayList<>();
		List<Integer> col = new ArrayList<>();
		for(int i=0;i<t;i++) {
			cut[i][0]=sc.nextInt();
			cut[i][1]=sc.nextInt();
			if(cut[i][0]==0)
				row.add(cut[i][1]);
			else
				col.add(cut[i][1]);
		}
		int[]map = new int [row.size()+1];
		int[]ymap = new int [col.size()+1];
		Collections.sort(row, Collections.reverseOrder());
		Collections.sort(col, Collections.reverseOrder());
		map[0]=m;
		for(int i=0;i<row.size();i++){
			map[i]=map[i]-row.get(i);
			map[i+1]=row.get(i);
		}
		ymap[0]=n;
		for(int i=0;i<col.size();i++) {
			ymap[i]=ymap[i]-col.get(i);
			ymap[i+1]=col.get(i);
		}
		int max=Integer.MIN_VALUE;
		for(int i=0;i<map.length;i++) {
			for(int j=0; j<ymap.length;j++) {
				int a = map[i]*ymap[j];
				if(max<a)
					max=a;
			}
		}
		System.out.println(max);
	}
}