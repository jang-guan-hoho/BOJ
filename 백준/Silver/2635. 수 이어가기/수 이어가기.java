import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main { 
	static List<Integer> st = new ArrayList<>();
	static int cmp() {
		return st.get(st.size()-2)-st.get(st.size()-1);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> ans = new ArrayList<>();
		int n = sc.nextInt();
		int max = Integer.MIN_VALUE;
		for(int i=0;i<=n;i++) {
			st.add(n);
			st.add(i);
			while(cmp()>=0) {
				st.add(cmp());
			}
			if(st.size()>max) {
				ans.removeAll(ans);
				max=st.size();
				ans.addAll(st);
			}
			st.removeAll(st);
		}
		System.out.println(max);
		for(int i=0;i<ans.size();i++)
			System.out.print(ans.get(i)+" ");
	}
}