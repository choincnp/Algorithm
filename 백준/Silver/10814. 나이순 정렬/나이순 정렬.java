import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.valueOf(st.nextToken());
		ArrayList<String> person = new ArrayList<>();
		for (int i=0; i<N; i++) {
			person.add(br.readLine());
		}
		Collections.sort(person, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				int ageOne = Integer.parseInt(o1.split(" ")[0]);
				int ageTwo = Integer.parseInt(o2.split(" ")[0]);
				return ageOne - ageTwo;
			}
		});
		StringBuilder sb = new StringBuilder();
		for (String s : person) {
			sb.append(s).append("\n");
		}
		System.out.println(sb);
	}
}