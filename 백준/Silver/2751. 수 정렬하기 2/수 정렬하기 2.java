import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(bf.readLine());
		Set<Integer> set = new HashSet<>();
		for(int i=0;i<n;i++) {
			set.add(Integer.parseInt(bf.readLine()));
		}
		Integer[] arr= set.toArray(new Integer[0]);
		Arrays.sort(arr);
		for(int i=0;i<arr.length;i++) {
			sb.append(arr[i]).append("\n");
		}
		System.out.println(sb);
	}
}