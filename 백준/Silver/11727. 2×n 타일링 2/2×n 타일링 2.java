import java.io.IOException;
import java.util.Scanner;

public class Main {
	static int N;
	static long[] dp;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		dp = new long[1001];
		dp[1] = 1;
		dp[2] = 3;
		for (int i=3; i<=N; i++){
			dp[i] = (dp[i-1] + 2 * dp[i-2])%10007;
		}
		System.out.println(dp[N]);
	}
}