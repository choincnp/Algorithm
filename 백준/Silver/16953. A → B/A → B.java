import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static long A, B;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		int count = 1;
		while (A != B) {
			if (A > B) {
				count = -1;
				break;
			}
			if (B % 10 == 1) {
				B /= 10;
			} else if (B % 2 == 0) {
				B /= 2;
			} else {
				count = -1;
				break;
			}
			count++;
		}
		System.out.println(count);

	}
}