import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static boolean[] remote;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		remote = new boolean[10];
		Arrays.fill(remote, true);
		if (M != 0){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i=0; i<M; i++){
				remote[Integer.parseInt(st.nextToken())] = false;
			}
		}
		int diff = Math.abs(N - 100);
		for (int i=0; i<=999999; i++){
			String str = Integer.toString(i);
			boolean check = true;
			for (int j=0; j<str.length(); j++){
				if (!remote[str.charAt(j)-'0']) {
					check = false;
					break;
				}
			}
			if (check) {
				diff = Math.min(diff, Math.abs(N - i) + str.length());
			}
		}
		System.out.println(diff);
	}
}
