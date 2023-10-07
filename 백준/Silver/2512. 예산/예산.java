import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] budget;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		budget = new int[N];
		int max = Integer.MIN_VALUE;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++){
			budget[i] = Integer.parseInt(st.nextToken());
			if (budget[i] > max){
				max = budget[i];
			}
		}
		int budgetMax = Integer.parseInt(br.readLine());
		int start = 0;
		int end = max;
		while (start <= end){
			int mid = (start + end) / 2;
			int sum = 0;
			for (int i=0; i<N; i++){
				sum += Math.min(budget[i], mid);
			}
			if (sum <= budgetMax){
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		System.out.println(end);
	}
}
