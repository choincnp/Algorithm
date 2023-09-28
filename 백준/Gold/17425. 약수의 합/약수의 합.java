import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		long fx[] = new long[1000001];
		long dp[] = new long[1000001];
		int T = Integer.parseInt(br.readLine());
		Arrays.fill(fx, 1);
		for (int i=2; i < fx.length; i++){
			for (int j=1; j*i < fx.length; j++){
				fx[i*j] += i;
			}
		}
		dp[1] = 1;
		for (int i=2; i< fx.length; i++){
			dp[i] = dp[i-1] + fx[i];
		}

		while (T -- > 0){
			int N = Integer.parseInt(br.readLine());
			sb.append(dp[N]).append("\n");
		}
		System.out.println(sb.toString());
	}
}