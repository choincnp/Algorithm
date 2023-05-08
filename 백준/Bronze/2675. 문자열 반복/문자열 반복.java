import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		for (int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			StringBuilder sb = new StringBuilder();
			while (st.hasMoreTokens()){
				String s = st.nextToken();
				for (int j=0; j<s.length(); j++){
					for (int k=0; k<R; k++){
						sb.append(s.charAt(j));
					}
				}
			}
			System.out.println(sb.toString());
		}
	}
}