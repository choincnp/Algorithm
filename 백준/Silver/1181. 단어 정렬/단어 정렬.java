import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) throws IOException {
		TreeSet<String> set = new TreeSet<>(
			(o1, o2) -> {
				if (o1.length() == o2.length()){
					return o1.compareTo(o2);
				} else {
					return o1.length() - o2.length();
				}
			}
		);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for (int i=0; i<N; i++){
			set.add(br.readLine());
		}
		while(!set.isEmpty()){
			sb.append(set.pollFirst()).append("\n");
		}
		System.out.println(sb);
	}
}