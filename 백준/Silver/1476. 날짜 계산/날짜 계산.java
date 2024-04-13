import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		System.out.println(calculateYear(E, S, M));
	}
	static int calculateYear(int E, int S, int M){
		int e = 1;
		int s = 1;
		int m = 1;
		int count = 1;
		while (true){
			if (e == E && s == S && m == M){
				return count;
			} else {
				e = e % 15 + 1;
				s = s % 28 + 1;
				m = m % 19 + 1;
			}
			count++;
		}
	}
}