import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    static int[][] dp = new int[41][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        IntStream.rangeClosed(0, 40).forEach(i -> Arrays.fill(dp[i], -1));
        dp[0][1] = 0;
        dp[0][0] = 1;
        dp[1][1] = 1;
        dp[1][0] = 0;
        int T = Integer.parseInt(br.readLine());
        while (T -- > 0){
            int N = Integer.parseInt(br.readLine());
            fibonacci(N);
            sb.append(dp[N][0]).append(" ").append(dp[N][1]).append("\n");
        }
        System.out.println(sb.toString());

    }
    static int[] fibonacci(int N){
        if (dp[N][0] == -1 || dp[N][1] == -1){
            dp[N][0] = fibonacci(N-1)[0] + fibonacci(N-2)[0];
            dp[N][1] = fibonacci(N-1)[1] + fibonacci(N-2)[1];
        }
        return dp[N];
    }
}