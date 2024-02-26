import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean result = false;
		int n = sc.nextInt();
		int ans= 0;
		for (int t = 1; t < n; t++) {
			ans = t;
			String s = Integer.toString(t);
			for (int i = 0; i < s.length(); i++) {
				ans += Character.getNumericValue(s.charAt(i));
			}
			if(n==ans) {
				ans = t;
				result = true;
				break;
			}
		}
		if(result) {
			System.out.println(ans);
		}else {
			System.out.println(0);
		}
	}
}