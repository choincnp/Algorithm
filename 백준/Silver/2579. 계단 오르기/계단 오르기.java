import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] dp;
    static int[] stairs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        stairs = new int[T+1];
        dp = new int[T+1];
        for (int i=1; i<=T; i++){
            int score = Integer.parseInt(br.readLine());
            stairs[i] = score;
        }
        dp[1] = stairs[1];
        if (T >=2 ){
            dp[2] = stairs[1] +stairs[2];
        }
        for (int i=3; i<=T; i++){
            dp[i] = Math.max(dp[i-2], dp[i-3]+stairs[i-1]) + stairs[i];
        }
        System.out.println(dp[T]);

    }

}