import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] dp;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		dp = new int[30][30];
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0){
			st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			sb.append(combination(N, R)).append("\n");
		}
		System.out.println(sb.toString());
	}
	static int combination(int N, int R){
		if (dp[N][R] > 0){
			return dp[N][R];
		}
		if (N==R || R == 0){
			return dp[N][R] = 1;
		}
		return dp[N][R] = combination(N-1, R-1) + combination(N-1, R);
	}
}