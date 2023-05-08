import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		int answer = Integer.MAX_VALUE;
		int lcnt = 0;
		int rcnt = 0;
		int sum = 0;
		for (int i=0; i<N; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		while(true) {
			if (sum >= M){
				sum -= arr[lcnt++];
				answer = Math.min(answer, rcnt-lcnt+1);
			}
			else if (rcnt == N) break;
			else sum += arr[rcnt++];
		}
		System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);
	}
}