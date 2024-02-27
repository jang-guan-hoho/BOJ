import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        long[] cables = new long[K];
        
        for(int i = 0; i<K; i++) {
        	cables[i] = Long.parseLong(br.readLine());
        }
        
        Arrays.sort(cables);

        long left = 1;
        long right = cables[K - 1];
        long maxLength = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;

            for (long cable : cables) {
                count += cable / mid;
            }

            if (count >= N) {
                maxLength = Math.max(maxLength, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        bw.write((int)maxLength+"");

        
        bw.flush();
        bw.close();
        br.close();
    
	}
}