import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long[] arr;
	static long[] sum;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new long[N];
		sum = new long[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int L = 0;
		int R = 0;
		int count = 0;
		int sum = 0;
		while (true) {
			if (sum >= M){
				sum -= arr[L++];
			} else if (R == N){
				break;
			} else {
				sum += arr[R++];
			}
			if (sum == M){
				count++;
			}
		}
		System.out.println(count);
	}
}