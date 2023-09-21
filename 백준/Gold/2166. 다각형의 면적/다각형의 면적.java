import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		long[][] arr = new long[T+1][2];
		for (int i=0; i<T; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		arr[T][0] = arr[0][0];
		arr[T][1] = arr[0][1];
		long aSum = 0;
		long bSum = 0;
		for (int i=0; i<T ; i++){
			aSum += arr[i][0] * arr[i+1][1];
			bSum += arr[i+1][0] * arr[i][1];
		}
		System.out.printf("%.1f", Math.abs(aSum - bSum) / 2.0);
	}
}
