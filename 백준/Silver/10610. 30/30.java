import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        int[] cnt = new int[10];
        int total = 0;
        for (int i=0; i<N.length(); i++){
            int num = N.charAt(i)-'0';
            cnt[num]++;
            total += num;
        }
        if (total % 3 != 0 || cnt[0] == 0){
            System.out.println(-1);
        } else {
            for (int i=9; i>=0; i--){
                while (cnt[i] > 0){
                    System.out.print(i);
                    cnt[i]--;
                }
            }
        }
    }
}