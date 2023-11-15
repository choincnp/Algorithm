import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int T, N;
    static int[][] dp;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while (T-- > 0){
            N = Integer.parseInt(br.readLine());
            dp = new int[2][N+1];
            arr = new int[2][N+1];
            for (int i=0; i<2; i++){
                st = new StringTokenizer(br.readLine());
                for (int j=1; j<=N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];
            for (int i=2; i<N+1; i++){
                dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + arr[0][i];
                dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + arr[1][i];
            }
            sb.append(Math.max(dp[0][N], dp[1][N])).append("\n");
        }
        System.out.println(sb);
    }
}