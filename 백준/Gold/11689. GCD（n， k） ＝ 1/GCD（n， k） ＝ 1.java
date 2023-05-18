import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long N = Long.parseLong(st.nextToken());
		long result = N;
		for (long l = 2; l * l <= N; l++){
			if (N % l == 0){
				result = result / l * (l - 1);
				while (N % l == 0){
					N /= l;
				}
			}
		}
		if (N > 1) {
			result -= result / N;
		}
		System.out.println(result);
	}

}