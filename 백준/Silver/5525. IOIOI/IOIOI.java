import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		char[] arr = br.readLine().toCharArray();
		int[] dp = new int[M];
		int count = 0;
		for (int i = 1; i < M-1; i++) {
			if(arr[i]=='O'&&arr[i+1]=='I') {
				dp[i+1] = dp[i-1]+1;
				if(dp[i+1] >= N && arr[i - 2 * N + 1] == 'I') count++;
			}
		}
		System.out.println(count);
	}
}