import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		Set<String> set = new HashSet<>();
		int answer = 0;
		while (T-- > 0){
			String line = br.readLine();
			if (line.equals("ENTER")) {
				set.clear();
			} else {
				if(set.contains(line)){
					continue;
				} else {
					answer++;
					set.add(line);
				}
			}
		}
		System.out.println(answer);
	}
}
