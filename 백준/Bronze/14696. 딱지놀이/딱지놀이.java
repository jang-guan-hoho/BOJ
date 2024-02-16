import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int t =0; t<N;t++) {
			int num1 = sc.nextInt();
			Integer[] st1 = new Integer [num1];
			for(int i=0;i<st1.length;i++) {
				st1[i]=sc.nextInt();
			}
			int num2 = sc.nextInt();
			Integer[] st2 = new Integer [num2];
			for(int i=0;i<st2.length;i++) {
				st2[i]=sc.nextInt();
			}
			Arrays.sort(st1, Collections.reverseOrder());
			Arrays.sort(st2, Collections.reverseOrder());
			int i=0
					;
			while(true) {
				if(st1[i]>st2[i]) {
					System.out.println("A");
					break;
				}else if(st1[i]<st2[i]) {
					System.out.println("B");
					break;
				}
				i++;
				if(st1.length==i&&st2.length==i) {
					System.out.println("D");
					break;
				}else if(st1.length==i) {
					System.out.println("B");
					break;
				}else if(st2.length==i){
					System.out.println("A");
					break;
				}
			}
		}
	}
}