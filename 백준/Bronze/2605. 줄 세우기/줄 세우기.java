import java.util.Scanner;

public class Main {
	public static void swap(int a, int b) {

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] std = new int[n];
		for (int i = 0; i < n; i++) {
			std[i] = i + 1;
		}
		for (int i = 0; i < n; i++) {
			int a = i - sc.nextInt();
			for (int j = i; j > a; j--) {
				int temp = std[j];
				std[j] = std[j-1];
				std[j-1] = temp;
			}
		}
		for (int i : std) {
			System.out.print(i + " ");
		}
	}
}