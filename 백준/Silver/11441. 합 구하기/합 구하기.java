import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] sum = new int[N+1];
		st = new StringTokenizer(br.readLine());
		sum[0] = 0;
		for (int i=1; i<=N; i++){
			sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		while (M -- > 0){
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			sb.append(sum[e] - sum[s-1]).append("\n");
		}
		System.out.println(sb.toString());
	}
}