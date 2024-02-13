import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int cnt=s.length();
		for(int i=1;i<s.length();i++) {
			if(s.charAt(i)=='='){
				cnt--;
				if(i>1&&s.charAt(i-1)=='z'&&s.charAt(i-2)=='d') {
					cnt--;
				}
			}else if(s.charAt(i)=='-') {
				cnt--;
			}else if(s.charAt(i)=='j'&&s.charAt(i-1)=='l') {
				cnt--;
			}else if(s.charAt(i)=='j'&&s.charAt(i-1)=='n') {
				cnt--;
			}
		}
		System.out.println(cnt);
	}
}