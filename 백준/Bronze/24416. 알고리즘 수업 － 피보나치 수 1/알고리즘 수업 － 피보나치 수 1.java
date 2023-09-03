import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        sb.append(recursion(T)).append(" ").append(T-2);
        System.out.println(sb.toString());

    }
    static int recursion(int N){
        int[] dp = new int[N+1];
        dp[1] = dp[2] = 1;
        for (int i=3; i<=N; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[N];
    }

}