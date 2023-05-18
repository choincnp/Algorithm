import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringBuilder sb = new StringBuilder();
		sb.append(s.substring((s.length()+1)/2, s.length()));
		if (s.substring(0, s.length()/2).equals(sb.reverse().toString()))
			System.out.println(1);
		else
			System.out.println(0);
	}
}