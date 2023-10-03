import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	static int N;
	static long[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		dp = new long[101];
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		dp[4] = 2;
		for (int i=4; i<=100; i++){
			dp[i] = dp[i-2] + dp[i-3];
		}
		while (N-- > 0){
			sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");
		}
		System.out.println(sb.toString());
	}
}
