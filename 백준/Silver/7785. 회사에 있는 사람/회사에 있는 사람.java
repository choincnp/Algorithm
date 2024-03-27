import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static StringTokenizer st;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		Set<String> set = new TreeSet<>(Collections.reverseOrder());
		while (T -- > 0){
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String status = st.nextToken();
			if (status.equals("enter")) set.add(name);
			else set.remove(name);
		}
		for (String name : set){
			sb.append(name).append("\n");
		}
		System.out.println(sb);
	}
}