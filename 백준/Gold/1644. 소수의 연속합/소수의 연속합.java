import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int N;
	static boolean[] notPrime;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		notPrime = new boolean[N+1];
		for (int i=2; i<N+1; i++){
			for (int j=i+i; j<N+1; j+=i){
				notPrime[j] = true;
			}
		}
		ArrayList<Integer> prime = new ArrayList<>();
		for (int i=2; i<N+1; i++){
			if (!notPrime[i]) prime.add(i);
		}
		int start = 0;
		int end = 0;
		long sum = 2;
		long count = 0;
		while (end != prime.size()){
			if (sum == N){
				count++;
				sum -= prime.get(start++);
			} else if (sum > N){
				sum -= prime.get(start++);
			} else {
				end++;
				if(end >= prime.size()) break;
				sum += prime.get(end);
			}
		}
		System.out.println(count);
	}
}
