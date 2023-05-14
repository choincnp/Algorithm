import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long n = Integer.parseInt(st.nextToken());
		long k = Integer.parseInt(st.nextToken());
		System.out.println(k==0? 1 : factorial(n) / factorial(k) / factorial(n-k));
	}
	public static long factorial(long n){
		if(n==0) return 1;
		return n*factorial(n-1);
	}
}