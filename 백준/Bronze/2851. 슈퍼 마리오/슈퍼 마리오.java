import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] map = new int [10];
		int sum=0;
		int min = Integer.MAX_VALUE;
		for(int i=0;i<10;i++) {
			sum+=sc.nextInt();
			map[i]=sum;
		}
		for(int i=0;i<10;i++) {
			int num;
			if(map[i]>100)
				num=map[i]-100;
			else
				num=100-map[i];
			if(num<=min) {
				min=num;
				sum=map[i];
			}
		}
		System.out.println(sum);
	}
}