import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int L = 0;
		int R = L+M;
		int sum = 0;
		for (int i=0; i<M; i++){
			sum += arr[i];
		}
		int max = sum;
		while (R != N) {
			sum = sum + arr[R++] - arr[L++];
			max = Math.max(max, sum);
		}
		System.out.println(max);
	}
}