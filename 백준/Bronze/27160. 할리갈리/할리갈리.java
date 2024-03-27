import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int order = Integer.parseInt(br.readLine());
		Map<String, Integer> map = new HashMap<>();
		map.put("STRAWBERRY", 0);
		map.put("BANANA", 0);
		map.put("LIME", 0);
		map.put("PLUM", 0);
		String fruit = "";
		while (order -- > 0){
			st = new StringTokenizer(br.readLine());
			fruit = st.nextToken();
			int card = Integer.parseInt(st.nextToken());
			map.put(fruit, map.getOrDefault(fruit, 0)+card);
		}
		boolean flag = false;
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 5) {
				flag = true;
				break;
			}
		}
		if (flag) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

	}
}