import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s = br.readLine();
		int N = s.length();
		int[][] sum = new int[26][N];
		for (int i=0; i<s.length(); i++){
			int ch = s.charAt(i)-'a';
			// 6번째에 j
			for (int j=i; j<N; j++){
				sum[ch][j]++;
			}
		}
		int q = Integer.parseInt(br.readLine());
		while (q -- > 0){
			st = new StringTokenizer(br.readLine());
			int alpha = st.nextToken().charAt(0) - 'a';
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			if (start == 0){
				sb.append(sum[alpha][end]).append("\n");
			} else {
				sb.append(sum[alpha][end] - sum[alpha][start-1]).append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}