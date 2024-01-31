import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for(int t=1; t<=T;t++) {
			int cnt=0;
			int man=0;
			String s = sc.nextLine();
			int[] num = new int[s.length()];
			for(int i=0; i<s.length();i++) {
				num[i]=Character.getNumericValue(s.charAt(i));
			}
			for(int i=0;i<num.length;i++) {
				if(num[i]==0&&man==0) {
					cnt++;
				}
				else if(num[i]==0&&man!=0) {
					num[i]=1;
					man--;
				}
				else
					man+=(num[i]-1);
			}
			System.out.println("#"+t+" "+cnt);
		}
	}
}