import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		long[] S = new long[N];
		long[] C = new long[M];
		long answer = 0;
		S[0] = sc.nextInt();
		for (int i=1; i<N; i++){
			S[i] = S[i-1] + sc.nextInt();
		}
		for (int i=0; i<N; i++){
			int mod = (int)(S[i] % M);
			if (mod == 0) answer++;
			C[mod]++;
		}
		for (int i=0; i<M; i++){
			if (C[i] >= 2) {
				answer += C[i] * (C[i] - 1) / 2;
			}
		}
		System.out.println(answer);
	}
}