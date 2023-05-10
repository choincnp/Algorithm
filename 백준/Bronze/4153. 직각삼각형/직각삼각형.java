import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			if (a == 0 && b == 0 && c == 0)
				break;
			else{
				long Max = Math.max(a, Math.max(b, c));
				if (Math.pow(Max,2) == Math.pow(a,2) + Math.pow(b,2) + Math.pow(c,2) - Math.pow(Max,2))
					System.out.println("right");
				else
					System.out.println("wrong");
			}
		}
	}
}