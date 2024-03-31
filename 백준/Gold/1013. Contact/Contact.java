import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Main{

	static String pattern = "(100+1+|01)+";

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0){
			sb.append(Pattern.matches(pattern, br.readLine()) ? "YES\n" : "NO\n");
		}
		System.out.println(sb);
	}
}