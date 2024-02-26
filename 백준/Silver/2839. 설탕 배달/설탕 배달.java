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
       
        int countT = 0;
        int countF = 0;
        int extra = 0;
        
        countF = N/5;
        extra = N%5;
        countT = extra/3;
        extra = extra%3;
        int totalCount = Integer.MAX_VALUE;
        boolean isTrue = false;
        if(extra==0) {
        	isTrue = true;
        	totalCount = countF+countT;
        }
        
        
        for(int i = countF-1; i>=0; i--) {
        	countF--;
        	extra +=5;
        	countT += extra/3;
        	extra = extra%3;
        	if(countF+countT<=totalCount && extra==0) {
        		isTrue = true;
        		totalCount = countF+countT;
        	}
        }
        
        if(!isTrue && extra != 0) {
        	totalCount = -1;
        }
        
        bw.write(totalCount+"");
        bw.newLine();
        
        bw.flush();
        bw.close();
        br.close();
    
	}
}