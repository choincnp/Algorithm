import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Set<Integer> set = new HashSet<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		while (N-- > 0){
			set.add(Integer.parseInt(st.nextToken()));
		}
		ArrayList<Integer> list = new ArrayList<>(set);
		Collections.sort(list);
		for (int i : list){
			sb.append(i).append(" ");
		}

		System.out.println(sb.toString());
	}
}