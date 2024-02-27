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
	
        int T = Integer.parseInt(br.readLine());
       
        for(int tc = 1; tc<=T; tc++) {
        	
        	Queue<Integer> document = new LinkedList<>();
        	Queue<Integer> documentList = new LinkedList<>();
        	int[] numberList = new int[10];
        	
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	
        	int N = Integer.parseInt(st.nextToken());
        	int M = Integer.parseInt(st.nextToken());
        	
        	st = new StringTokenizer(br.readLine());
        	
        	for(int i = 0; i<N; i++) {
        		int X = Integer.parseInt(st.nextToken());
        		document.add(X);
        		documentList.add(i);
        		numberList[X]++;
        	}
        	
        	int count = 0;
        	
        	print: while(true) {
        		int X = documentList.poll();
        		int Y = document.poll();
        		
        		for(int i = Y+1; i<10; i++) {
        			if(numberList[i]!=0) {
        				document.add(Y);
        				documentList.add(X);
        				continue print;
        			}
        		}

    			if(X==M) {
    				count++;
    				break print;
    			}else {
    				numberList[Y]--;
    				count++;
    			}
        		
        	}
        	
        	bw.write(count+"");
            bw.newLine();
            
        }
        bw.flush();
        bw.close();
        br.close();
    
	}
}