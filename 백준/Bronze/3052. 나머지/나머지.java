import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Set<Integer> st = new HashSet<>();
		for(int t=0;t<10;t++) {
			st.add(sc.nextInt()%42);
		}
		System.out.println(st.size());
	}
}