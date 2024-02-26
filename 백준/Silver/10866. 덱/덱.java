import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
        int N = Integer.parseInt(br.readLine());
        
        Deque<Integer> deque = new LinkedList<>();
        
        for(int i = 0; i<N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	String line = st.nextToken();
        	if(line.equals("push_front")) {
        		deque.addFirst(Integer.parseInt(st.nextToken()));
        	}else if(line.equals("push_back")) {
        		deque.addLast(Integer.parseInt(st.nextToken()));
        	}else if(line.equals("pop_front")) {
        		if(!deque.isEmpty()) {
            		bw.write(deque.pollFirst()+"");
            		bw.newLine();
        		}else {
        			bw.write("-1");
            		bw.newLine();
        		}
        	}else if(line.equals("pop_back")) {
        		if(!deque.isEmpty()) {
            		bw.write(deque.pollLast()+"");
            		bw.newLine();
        		}else {
        			bw.write("-1");
            		bw.newLine();
        		}
        	}else if(line.equals("size")) {
        		bw.write(deque.size()+"");
        		bw.newLine();
        	}else if(line.equals("empty")) {
        		if(deque.isEmpty()) {
        			bw.write("1");
            		bw.newLine();
        		}else {
        			bw.write("0");
            		bw.newLine();
        		}
        	}else if(line.equals("front")) {
        		if(!deque.isEmpty()) {
        			bw.write(deque.peekFirst()+"");
            		bw.newLine();
        		}else {
        			bw.write("-1");
            		bw.newLine();
        		}
        	}else if(line.equals("back")) {
        		if(!deque.isEmpty()) {
        			bw.write(deque.peekLast()+"");
            		bw.newLine();
        		}else {
        			bw.write("-1");
            		bw.newLine();
        		}
        	}
        }
        
        bw.flush();
        bw.close();
        br.close();
    
	}
}