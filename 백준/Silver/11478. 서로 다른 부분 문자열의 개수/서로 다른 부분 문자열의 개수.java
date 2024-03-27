import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String letter = br.readLine();
		Set<String> set = new HashSet<>();
		for (int i=0; i<letter.length(); i++){
			for (int j=i; j< letter.length(); j++){
				set.add(letter.substring(i, j+1));
			}
		}
		System.out.println(set.size());
	}
}