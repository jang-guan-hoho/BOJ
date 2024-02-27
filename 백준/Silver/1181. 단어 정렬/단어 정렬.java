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
        
        int N = Integer.parseInt(br.readLine());
	
        Set<String> words = new TreeSet<>(Comparator.comparing(String::length).thenComparing(String::compareTo));
        
        for (int i = 0; i < N; i++) {
            words.add(br.readLine());
        }

        words.forEach(System.out::println);
        
        bw.flush();
        bw.close();
        br.close();
    
	}
}