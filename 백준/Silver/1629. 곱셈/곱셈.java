import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long C;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		C = Long.parseLong(st.nextToken());
		System.out.println(function(A, B));
	}
	static long function(long A, long B){
		if (B == 1) return A%C;
		else {
			long res = function(A, B/2);
			if (B%2 == 0) return res * res % C;
			else return (res * res % C) * A % C;
		}
	}
}