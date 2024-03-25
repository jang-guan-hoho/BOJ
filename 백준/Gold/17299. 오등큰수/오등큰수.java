import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();

		int N = Integer.parseInt(br.readLine());
		int[] data = new int[N]; // 행렬에 데이터 저장
		int[] cnt = new int[1000001]; // 숫자 카운트 배열
		boolean[] rs = new boolean[1000001];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			data[i] = Integer.parseInt(st.nextToken());

		Stack<Integer> s = new Stack<>();

		for(int i = 0 ; i < N ; i++) {
			cnt[data[i]]++;
			rs[data[i]] = true; // 배열에 존재하는 값 표시
		}
		
		
		for (int i = 0; i < N; i++) {
			if(!rs[data[i]])continue;
			while (!s.isEmpty() && cnt[data[s.peek()]] < cnt[data[i]]) {
				data[s.pop()] = data[i];
			}

			s.add(i); // 인덱스가 들어가는것에 주목
		}

		while (!s.isEmpty())
			data[s.pop()] = -1;

		for (int i = 0; i < N; i++)
			sb.append(data[i]).append(" ");

		System.out.println(sb);
	}
}