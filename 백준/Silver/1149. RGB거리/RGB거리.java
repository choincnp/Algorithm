import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] dp = new int[N+1][4];
		for (int i=1; i<N+1; i++){
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			if (i==1) {
				dp[i][1] = x;
				dp[i][2] = y;
				dp[i][3] = z;
			} else{
				dp[i][1] = Math.min(dp[i-1][2]+x, dp[i-1][3]+x);
				dp[i][2] = Math.min(dp[i-1][1]+y, dp[i-1][3]+y);
				dp[i][3] = Math.min(dp[i-1][1]+z, dp[i-1][2]+z);
			}
		}
		System.out.println(Math.min(dp[N][1], Math.min(dp[N][2], dp[N][3])));
	}
}