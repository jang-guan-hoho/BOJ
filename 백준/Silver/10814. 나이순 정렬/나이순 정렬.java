import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] age;
	static String[] name;
	static int[] arr;
	static String[] cname;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		age = new int [N];
		name = new String [N];
		arr = new int [N];
		cname = new String[N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			age[i] = Integer.parseInt(st.nextToken());
			name[i] = st.nextToken();
		}
		
		mergeSort(0, N-1);
		for(int i=0;i<N;i++) {
			System.out.println(age[i]+" "+name[i]);
		}
	}

	static void mergeSort(int left, int right) {
		if (left < right) {

			int mid = (left + right) / 2;
			mergeSort(left, mid);
			mergeSort(mid + 1, right);
			merge(left, mid, right);
		}
	}

	private static void merge(int left, int mid, int right) {
		int L = left;
		int R = mid + 1;
		int idx = left;

		while (L <= mid && R <= right) {
			if (age[L] <= age[R]) {
				cname[idx] = name[L];
				arr[idx++] = age[L++];
			}
			else {
				cname[idx] = name[R];
				arr[idx++] = age[R++];
			}
		}
		// 위에 결과로 sortedArr에 마지막 인덱스를 제외하고 정렬됨
		// 따라서 마지막 인덱스를 채워야한다.
		if (L <= mid) {
			for (int i = L; i <= mid; i++) {
				cname[idx] = name[i];
				arr[idx++] = age[i];
			}
		} else {
			for (int i = R; i <= right; i++) {
				cname[idx] = name[i];
				arr[idx++] = age[i];
			}
		}
		// 배열 갱신
		for (int i = left; i <= right; i++) {
			name[i] = cname[i];
			age[i] = arr[i];
		}
	}
}