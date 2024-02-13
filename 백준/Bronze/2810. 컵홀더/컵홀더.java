import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		Character[] sht = new Character[n];
		int cnt=1;
		int c_cnt=0;
		sc.nextLine();
		String s = sc.nextLine();
		for(int i=0;i<sht.length;i++) {
			sht[i]=s.charAt(i);
		}
		for(int i=0;i<sht.length;i++) {
			if(sht[i]=='L') {
				cnt++;
				i++;
			}else {
				cnt++;
			}
		}
		if(cnt>n) {
			cnt=n;
		}
		System.out.println(cnt);
	}
}