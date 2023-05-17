import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		Map<Integer, Integer> pocket = new HashMap<>();
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++){
			int num = Integer.parseInt(st.nextToken());
			pocket.put(num, pocket.getOrDefault(num,0)+1);
		}
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<M; i++){
			int num = Integer.parseInt(st.nextToken());
			if (i == M - 1) {
				sb.append(pocket.getOrDefault(num, 0));
			} else {
				sb.append(pocket.getOrDefault(num, 0)).append(" ");
			}
		}
		System.out.println(sb);
	}
}