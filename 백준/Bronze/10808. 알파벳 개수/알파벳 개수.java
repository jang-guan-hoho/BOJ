import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	static String[] alpa = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
	static int[] cnt = new int[26];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		Stack<String> st = new Stack<>();
		for(int i = 0 ; i<s.length(); i++) {
			st.add(s.substring(i, i+1));
		}
		while(!st.isEmpty()) {
			String t = st.pop();
			for(int i = 0 ; i < 26; i++) {
				if(t.equals(alpa[i])) {
					cnt[i]++;
				}
			}
		}
		for(int x : cnt) {
			System.out.print(x+" ");
		}
	}
}