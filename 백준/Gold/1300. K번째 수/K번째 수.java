import java.util.Scanner;

public class Main {
	static int N, k;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		k = sc.nextInt();
		int start = 1;
		int end = k;
		int answer = 0;
		while (start <= end){
			int middle = (start + end) / 2;
			int count = 0;
			for (int i=1; i<=N; i++){
				count += Math.min(middle/i, N);
			}
			if (count < k){
				start = middle + 1;
			} else {
				end = middle - 1;
				answer = middle;
			}
		}
		System.out.println(answer);
	}
}
