import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder ioi = new StringBuilder("I");
		while (N-- > 0){
			ioi.append("OI");
		}
		int M = Integer.parseInt(br.readLine());
		String target = br.readLine();
		int count = 0;
		for (int i=0; i<target.length()-N-1; i++){
			if (target.startsWith(ioi.toString(), i)) count++;
		}
		System.out.println(count);
	}
}