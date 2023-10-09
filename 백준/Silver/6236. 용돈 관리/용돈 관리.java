import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] pleasure;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		pleasure = new int[N];
		int min = 0;
		int sum = 0;
		for (int i=0; i<N; i++){
			pleasure[i] = Integer.parseInt(br.readLine());
			sum += pleasure[i];
			if (min < pleasure[i]) min = pleasure[i];
		}
		int start = min;
		int end = sum;
		// 이거 이분탐색 해야함 누적합 하면 계좌에 다시 넣는거 할수는 있겠는데 복잡하다
		while (start <= end){
			int mid = (start + end) / 2;
			int balance = 0;
			int count = 1;
			for (int i=0; i<N; i++){
				balance += pleasure[i];
				if (balance > mid){
					balance = pleasure[i];
					count++;
				}
			}
			if (count <= M){
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		System.out.println(start);
	}
}
