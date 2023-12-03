import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        while (N-- > 0){
            boolean[] check = new boolean[26];
            boolean flag = true;
            int now = 0;
            String word = br.readLine();
            for (int i=0; i<word.length(); i++){
                int next = word.charAt(i);
                if (now == next) continue;
                else {
                    if (check[next-'a'] == false){
                        check[next-'a'] = true;
                        now = next;
                    } else {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) answer++;
        }
        System.out.println(answer);
    }
}