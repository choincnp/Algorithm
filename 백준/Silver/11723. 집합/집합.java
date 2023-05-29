import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		Set<Integer> set = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		while (N --> 0){
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			switch (command){
				case "add":
					set.add(Integer.parseInt(st.nextToken()));
					break;
				case "remove":
					set.remove(Integer.parseInt(st.nextToken()));
					break;
				case "check":
					if (set.contains(Integer.parseInt(st.nextToken()))) {
						sb.append(1).append("\n");
					} else {
						sb.append(0).append("\n");
					}
					break;
				case "toggle":
					int num = Integer.parseInt(st.nextToken());
					if (set.contains(num)) {
						set.remove(num);
					} else {
						set.add(num);
					}
					break;
				case "all":
					set.clear();
					for (int i = 1; i <= 20; i++) {
						set.add(i);
					}
					break;
				case "empty":
					set.clear();
					break;
			}
		}
		System.out.println(sb);
	}
}