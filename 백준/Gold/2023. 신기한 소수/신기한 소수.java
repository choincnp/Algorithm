import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		DFS(2,1);
		DFS(3,1);
		DFS(5,1);
		DFS(7,1);
	}
	public static void DFS(int number, int digit){
		if (digit == N){
			if (isPrime(number)) System.out.println(number);
			return;
		}
		for (int i=0; i<10; i++){
			if (i % 2 == 0) continue;
			if (isPrime(number*10 + i)) DFS(number*10 + i, digit+1);
		}
	}
	public static boolean isPrime(int n){
		for (int i=2; i<= Math.sqrt(n); i++){
			if (n % i == 0) return false;
		}
		return true;
	}
}