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
	
        List<String> members = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            members.add(br.readLine());
        }

        members.sort(Comparator.comparingInt(s -> Integer.parseInt(s.split(" ")[0])));

        for (String member : members) {
            System.out.println(member);
        }
        
        bw.flush();
        bw.close();
        br.close();
    
	}
}