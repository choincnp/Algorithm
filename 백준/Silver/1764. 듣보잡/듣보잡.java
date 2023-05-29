import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Map<String, Integer> pocket = new HashMap<>();
		for (int i=0; i<N+M; i++){
			String name = br.readLine();
			pocket.put(name, pocket.getOrDefault(name, 0)+1);
		}
		ArrayList<String> answer = new ArrayList<>();
		for (String name : pocket.keySet()){
			if (pocket.get(name) == 2){
				answer.add(name);
			}
		}
		Collections.sort(answer);
		sb.append(answer.size()).append("\n");
		for (int i=0; i<answer.size(); i++){
			sb.append(answer.get(i)).append("\n");
		}
		System.out.println(sb);
	}
}