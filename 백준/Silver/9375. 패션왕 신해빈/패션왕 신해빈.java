import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		while (N-- > 0){
			Map<String, Integer> map = new HashMap<>();
			int M = Integer.parseInt(br.readLine());
			int sum = 1;
			for (int i=0; i<M; i++){
				StringTokenizer st = new StringTokenizer(br.readLine());
				String cloth = st.nextToken();
				String category = st.nextToken();
				map.put(category, map.getOrDefault(category, 0)+1);
			}
			for (Map.Entry<String, Integer> entry : map.entrySet()) {
				sum *= entry.getValue() + 1;
			}
			sb.append(sum - 1).append("\n");
		}
		System.out.println(sb.toString());
	}
}
