import java.awt.image.DataBufferDouble;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void man(int n,int[] map) {
		for(int i=0;i<map.length;i++) {
			if((i+1)%n==0) {
				turn(i,map);
			}
		}
	}
	public static void turn(int i, int[] map) {
		if(map[i]==0) {
			map[i]=1;
		}
		else
			map[i]=0;
	}
	public static void woman(int n,int[] map) {
		int x=n-1;
		int i=1;
		turn(x,map);
		while(x-i>=0&&x+i<map.length) {
			if(map[x-i]==map[x+i]) {
				turn(x-i,map);
				turn(x+i,map);
				i++;
			}
			else
				break;
		}
		return;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[] map = new int[N];
		StringTokenizer st= new StringTokenizer(bf.readLine());
		for(int i=0;i<N;i++) {
			map[i]=Integer.parseInt(st.nextToken());
		}
		int stu = Integer.parseInt(bf.readLine());
		int [][] std = new int[stu][2];
		for(int i=0;i<stu;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int r=0;r<2;r++) {
				std[i][r]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<stu;i++) {	
			if(std[i][0]==1) {
				man(std[i][1],map);
			}
			else {
				woman(std[i][1],map);
			}
		}
        for(int i = 0; i < map.length; i++) {
        	System.out.print(map[i] + " ");
        	if(i % 20 == 19) {
        		System.out.println();
        	}
        }
	}
}
