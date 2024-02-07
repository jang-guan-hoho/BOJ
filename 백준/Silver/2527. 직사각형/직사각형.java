import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int test=0;test<4;test++) {
			String ans = "";
			int[] fs1 = {sc.nextInt(),sc.nextInt()};
			int[] fs2 = {sc.nextInt(),sc.nextInt()};
			int[] ss1 = {sc.nextInt(),sc.nextInt()};
			int[] ss2 = {sc.nextInt(),sc.nextInt()};
		if(ss1[0]>fs2[0]||ss1[1]>fs2[1]||fs1[0]>ss2[0]||fs1[1]>ss2[1]) {
			ans = "d";
		}else if(fs2[0]==ss1[0]&&fs2[1]==ss1[1]) {
			ans = "c";
		}else if(fs1[0]==ss2[0]&&fs1[1]==ss2[1]) {
			ans = "c";
		}else if(fs2[0]==ss1[0]&&fs1[1]==ss2[1]) {
			ans = "c";
		}else if(fs1[0]==ss2[0]&&fs2[1]==ss1[1]) {
			ans = "c";
		}else if(fs2[0]==ss1[0]||fs2[1]==ss1[1]||fs1[0]==ss2[0]||fs1[1]==ss2[1]) {
			ans = "b";
		}else {
			ans = "a";
		}
		System.out.println(ans);
		}
	}
}