import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String letter = br.readLine();
		TreeSet<String> set = new TreeSet<>();
		for (int i=0; i<letter.length(); i++){
			set.add(letter.substring(i, letter.length()));
		}
		for (String s : set) {
			sb.append(s).append("\n");
		}
		System.out.println(sb);
	}
}