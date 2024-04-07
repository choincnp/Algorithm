import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	/*
	 * 정수 개수 N개, 정수 S 주어짐
	 * 다 더해서 S가 되어야 함, 브루트포스로 접근
	 * 1. 배열을 만들어 수를 받는다.
	 * 2. 합이 넘으면 return하는 백트래킹을 만든다.
	 */
	static int[] arr;
	static int N, S, count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for (int i=0; i<N; i++){
			int depth = 0;
			backTracking(i, arr[i], depth);
		}
		System.out.println(count);
	}
	static void backTracking(int idx, int sum, int depth){
		if (idx == N) return;
		if (sum == S) {
			count++;
		}
		for (int i=idx+1; i< N; i++){
			backTracking(i, sum+arr[i], depth+1);
		}
	}
}
