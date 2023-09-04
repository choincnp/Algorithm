import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dp;
    static int[][] schedule;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        schedule = new int[T][2];
        dp = new int[T+1];
        for (int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            schedule[i][0] = Integer.parseInt(st.nextToken());
            schedule[i][1] = Integer.parseInt(st.nextToken());
        }
        for (int i=0; i<T; i++){
            int t = schedule[i][0];
            int p = schedule[i][1];
            if (i+t < T+1){
                dp[i+t] = Math.max(dp[i]+p, dp[i+t]);
            }
            dp[i+1] = Math.max(dp[i+1], dp[i]);
        }
        System.out.println(dp[T]);
    }
}
