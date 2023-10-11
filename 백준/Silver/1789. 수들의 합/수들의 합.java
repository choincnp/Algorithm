import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static long N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Long.parseLong(br.readLine());
		long sum = 0;
		long count = 0;
		while (true){
			sum += ++count;
			if (sum > N) break;
		}
		System.out.println(count - 1);
	}
}
