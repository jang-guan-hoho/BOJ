import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a1= sc.nextInt();
		int a= sc.nextInt();
		int c= sc.nextInt();
		int n0 = sc.nextInt();
		boolean result =false;
		if(a1<c&&a/(c-a1)<=n0) {
			result = true;
		}else if(a1==c&&a<=0) {
			result = true;
		}
		if(result) {
			System.out.println(1);
		}else
			System.out.println(0);
	}
}