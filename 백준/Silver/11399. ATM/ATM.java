import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Integer [] time = new Integer[N];
		for(int i=0;i<N;i++) {
			time[i]= sc.nextInt();
		}
		Arrays.sort(time);
		for(int i=1;i<N;i++) {
			time[i]+=time[i-1];
		}
		for(int i=1;i<N;i++) {
			time[i]+=time[i-1];
		}
		System.out.println(time[N-1]);
	}
}