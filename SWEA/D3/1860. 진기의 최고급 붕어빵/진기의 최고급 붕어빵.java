import java.util.Arrays;
import java.util.Scanner;
 
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=1; t<=T;t++) {
            int N =sc.nextInt();
            int M = sc.nextInt();
            int K = sc.nextInt();
            int cnt = 0;
            boolean result = true;
            int [] man = new int [N];
            for(int i=0;i<N;i++)
                man[i]=sc.nextInt();
            Arrays.sort(man);
            int [] bb = new int[man[N-1]+1];
            for(int i=0; i<bb.length;i++) {
                if(i%M==0&&i!=0) {
                    cnt+=K;
                }
                bb[i]=cnt;
                for(int n=0;n<man.length;n++) {
                    if(i==man[n]) {
                        bb[i]--;
                        cnt--;
                    }
                }
            }
            for(int i=0;i<bb.length;i++) {
            if(bb[i]<0)
                result = false;
            }
            if(result == true)
                System.out.println("#"+t+" "+"Possible");
            else
                System.out.println("#"+t+" "+"Impossible");
        }
    }
}