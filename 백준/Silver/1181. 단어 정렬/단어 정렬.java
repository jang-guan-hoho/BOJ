import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static String[] arr;
	static int N;
	static String[] sortedArr;
	static int[] cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new String[N];
		sortedArr = new String[N];
		cnt = new int[51];
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine();
			cnt[arr[i].length()]++;
		}
		mergeSort(0, arr.length - 1);
		for (int i = 1; i < 51; i++) {
			sort(i);
		}
		for (int i = 0; i < N; i++) {
			if (!arr[i].equals("0"))
				System.out.println(arr[i]);
		}
	}

	static void mergeSort(int left, int right) {
		// if(left >= right) return ; 이렇게 컷 하거나
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(left, mid);
			mergeSort(mid + 1, right);
			merge(left, mid, right);
		}
	}

	static void merge(int left, int mid, int right) {
		int L = left; // 왼쪽구간의 시작 표인트
		int R = mid + 1; // 오른쪽구간의 시작 포인트
		int idx = left; // 정렬된 원소 저장할 위치

		// 서로 아직 비교할 수 있는 값들이 남아있을 경우
		while (L <= mid && R <= right) {
			if (arr[L].length() <= arr[R].length()) {
				sortedArr[idx++] = arr[L++];
			} else
				sortedArr[idx++] = arr[R++];
		}

		// 위에 결과로 sortedArr에 마지막 인덱스를 제외하고 정렬됨
		// 따라서 마지막 인덱스를 채워야한다.
		if (L <= mid) {
			for (int i = L; i <= mid; i++)
				sortedArr[idx++] = arr[i];
		} else {
			for (int i = R; i <= right; i++) {
				sortedArr[idx++] = arr[i];
			}

		}
		// 배열 갱신
		for (int i = left; i <= right; i++)
			arr[i] = sortedArr[i];
	}

	static void sort(int N) {
		int sum = 0;
		for(int i = 0; i<N;i++) {
			sum+=cnt[i];
		}
		for (int i = sum; i < sum+cnt[N]; i++) {
			for (int j = sum; j < sum+cnt[N]-1; j++) {
				if (arr[j].equals(arr[j + 1])) {
					arr[j] = "0";
				}
				if (arr[j].compareTo(arr[j + 1]) > 0) {
					String tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
				}
			}
		}
	}
}