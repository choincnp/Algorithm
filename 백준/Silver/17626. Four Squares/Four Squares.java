import java.util.Scanner;

public class Main {
	static int[] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		dp = new int[50001];
		dp[1] = 1;
		for (int i=2; i<=N; i++){
			int max = 4;
			for (int j=1; j*j <= i ; j++){
				int tmp = i - j * j;
				max = Math.min(max, dp[tmp] + 1);
			}
			dp[i] = max;
		}
		System.out.println(dp[N]);
	}
}
