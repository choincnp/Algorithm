import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static Integer[] dp;
    static int[] stairs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        stairs = new int[T+1];
        dp = new Integer[T+1];
        for (int i=1; i<=T; i++){
            int score = Integer.parseInt(br.readLine());
            stairs[i] = score;
        }
        dp[0] = stairs[0];
        dp[1] = stairs[1];
        if (T >= 2){
            dp[2] = stairs[1] + stairs[2];
        }
        System.out.println(find(T));
    }
    static int find(int N){
        if (dp[N] == null){
            dp[N] = Math.max(find(N-2), find(N-3)+stairs[N-1]) + stairs[N];
            // 5층의 값을 찍으려면 3층 find과 2층 find + 4층값을 찍는다
        }
        return dp[N];
    }

}
