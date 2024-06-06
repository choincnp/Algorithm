import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = 10;
        int alphabet = 26;
        String str = br.readLine();
        char last = ' ';
        long count = 1;
        for (int i=0; i< str.length(); i++){
            char now = str.charAt(i);
            if (now == 'c'){
                if (now == last){
                    count = (count * (alphabet-1))%1000000009;
                } else {
                    count = (count * alphabet)%1000000009;
                }
            } else {
                if (now == last){
                    count = (count * (num-1))%1000000009;
                } else {
                    count = (count * num) % 1000000009;
                }
            }
            last = now;
        }
        System.out.println(count);
    }
}
