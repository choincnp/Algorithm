import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String numbers = br.readLine();
		long hash = 0;
		for (int i=0; i<N; i++){
			int n = (numbers.charAt(i)-'a'+1);
			int m = (int)Math.pow(31, i);
			hash += n*m;
		}
		System.out.println(hash%1234567891);
	}

}