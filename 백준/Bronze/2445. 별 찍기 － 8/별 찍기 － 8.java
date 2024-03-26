import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			// 왼쪽 별
			for (int j = 0; j <= i; j++) {
				sb.append("*");
			}
			// 가운데 공백
			for (int j = 0; j < 2 * (N - i - 1); j++) {
				sb.append(" ");
			}
			// 오른쪽 별
			for (int j = 0; j <= i; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		// 아랫부분
		for (int i = N - 2; i >= 0; i--) {
			// 왼쪽 별
			for (int j = 0; j <= i; j++) {
				sb.append("*");
			}
			// 가운데 공백
			for (int j = 0; j < 2 * (N - i - 1); j++) {
				sb.append(" ");
			}
			// 오른쪽 별
			for (int j = 0; j <= i; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}