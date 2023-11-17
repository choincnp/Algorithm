import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long fixed = Integer.parseInt(st.nextToken());
        long var = Integer.parseInt(st.nextToken());
        long price = Integer.parseInt(st.nextToken());
        if (price <= var){
            System.out.println(-1);
        } else {
            System.out.println((fixed / (price - var)) + 1);
        }
    }
}