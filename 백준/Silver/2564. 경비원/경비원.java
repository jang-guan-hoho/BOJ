import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt();
		int h = sc.nextInt();
		int n = sc.nextInt();
		int[][] shop = new int[n][2];
		int[] dg = new int[2];
		for(int i=0; i<n;i++) {
			shop[i][0]=sc.nextInt()-1;
			shop[i][1]=sc.nextInt();
		}
		dg[0]=sc.nextInt()-1;
		dg[1]=sc.nextInt();
		int way=0;
		for(int i=0;i<n;i++) {
		if(dg[0]/2==0&&shop[i][0]/2==0) {
			if(dg[0]!=shop[i][0]) {
				way+=h;
				way+=Math.min(dg[1]+shop[i][1],2*w-(dg[1]+shop[i][1]));
			}else {
				way+=(Math.max(dg[1], shop[i][1])-Math.min(dg[1], shop[i][1]));
			}
		}else if(dg[0]/2!=0&&shop[i][0]/2!=0){
			if(dg[0]!=shop[i][0]) {
				way+=w;
				way+=Math.min(dg[1]+shop[i][1],2*h-(dg[1]+shop[i][1]));
			}else {
				way+=(Math.max(dg[1], shop[i][1])-Math.min(dg[1], shop[i][1]));
			}
		}else if((dg[0]==0&&shop[i][0]==2)||(dg[0]==2&&shop[i][0]==0)) {
				way+=dg[1]+shop[i][1];	
		}else if((dg[0]==1&&shop[i][0]==3)||(dg[0]==3&&shop[i][0]==1)){
				way+=w+h-dg[1]-shop[i][1];
		}else if(dg[0]==1&&shop[i][0]==2) {
			way+=h-shop[i][1]+dg[1];
		}else if(dg[0]==2&&shop[i][0]==1) {
			way+=h+shop[i][1]-dg[1];
		}else if(dg[0]==0&&shop[i][0]==3) {
			way+=w+shop[i][1]-dg[1];
		}else {
			way+=w-shop[i][1]+dg[1];
		}
		}
		System.out.println(way);
	}
}