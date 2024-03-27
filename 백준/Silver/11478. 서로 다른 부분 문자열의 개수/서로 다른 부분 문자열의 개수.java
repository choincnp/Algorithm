import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;
	static char[] letter;
	static Set<String> set = new HashSet<>();

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		letter = br.readLine().toCharArray();
		for (int i = 0; i < letter.length; i++){
			createSubstring("", i);
		}
		System.out.println(set.size());
	}

	static void createSubstring(String current, int index){
		if (index == letter.length) return;
		String next = current + letter[index];
		set.add(next);
		createSubstring(next, index + 1);
	}
}