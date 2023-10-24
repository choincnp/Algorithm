import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        dp = new Integer[T+1];
        dp[0] = 0;
        dp[1] = 0;
        System.out.println(solution(T));
    }

    static int solution(int N){
        if (dp[N] == null){
            if (N%6 == 0){
                dp[N] = Math.min(solution(N-1), Math.min(solution(N/3), solution(N/2)))+1;
            }
            else if (N%3 == 0){
                dp[N] = Math.min(solution(N/3), solution(N-1))+1;
            }
            else if (N%2 == 0){
                dp[N] = Math.min(solution(N/2), solution(N-1))+1;
            }
            else dp[N] = solution(N-1) + 1;
        }
        return dp[N];
    }
}
