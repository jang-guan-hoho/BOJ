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
        
        List<Integer> numberList = new ArrayList<>();
        Map<Integer, Integer> count = new HashMap<>();
        
        for(int i = 0; i<N; i++) {
        	int num = Integer.parseInt(br.readLine());
        	numberList.add(num);
        	count.put(num, count.getOrDefault(num, 0) + 1);
        }
        
        
        Collections.sort(numberList);
        
        //산술평균
        double sum = 0;
        for(int i = 0; i<N; i++) {
        	sum += (double)numberList.get(i)/N;
        }
        bw.write(Math.round(sum)+"");
        bw.newLine();
        
        //중앙값
        bw.write(numberList.get(N/2)+"");
        bw.newLine();
        
        //최빈값
        List<Integer> frequencyNumbers = new ArrayList<>();
        int maxFrequency = 0;
        for(Map.Entry<Integer, Integer> entry : count.entrySet()) {
        	int frequency = entry.getValue();
            if (frequency > maxFrequency) {
                maxFrequency = frequency;
                frequencyNumbers.clear(); // 이전에 최빈값이었던 숫자들을 초기화
                frequencyNumbers.add(entry.getKey());
            } else if (frequency == maxFrequency) {
            	frequencyNumbers.add(entry.getKey());
            }
        }
        
        Collections.sort(frequencyNumbers);
        
        int secondNumber = frequencyNumbers.get(0); // 두 번째로 작은 최빈값 초기화
        if (frequencyNumbers.size() > 1) {
        	secondNumber = frequencyNumbers.get(1);
        }
        
        bw.write(secondNumber+"");
        bw.newLine();
        
        //범위
        bw.write(Math.abs(numberList.get(0) - numberList.get(N-1))+"");
        bw.newLine();
        
        bw.flush();
        bw.close();
        br.close();
    
	}
}