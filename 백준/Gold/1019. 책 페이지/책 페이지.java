import java.io.IOException;
import java.util.Scanner;

public class Main {
	static long[] count = new long[10];
	static int N;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		N = sc.nextInt();
		int digit = 1;
		int start = 1;
		while (start <= N){
			while (start % 10 != 0 && start <= N){
				calc(start, digit);
				start++;
			}
			while (N % 10 != 9 && start <= N){
				calc(N, digit);
				N--;
			}
			if (start > N) break;
			start /= 10;
			N /= 10;
			for (int i=0; i<10; i++){
				count[i] += (N - start + 1) * digit;
			}
			digit *= 10;
		}
		for (int i=0; i<10; i++){
			sb.append(count[i]).append(" ");
		}
		System.out.println(sb);

	}
	static void calc(int x, int digit){
		while (x > 0){
			count[x%10] += digit;
			x /= 10;
		}
	}
}