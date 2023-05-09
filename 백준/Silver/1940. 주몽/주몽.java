import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i=0; i<N; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int sum = 0;
		int count = 0;
		int start_idx = 0;
		int end_idx = N-1;
		while (end_idx != start_idx){
			sum = arr[start_idx] + arr[end_idx];
			if (sum == M){
				count++;
				start_idx++;
			}
			else if (sum > M){
				end_idx--;
			}
			else{
				start_idx++;
			}
		}
		System.out.println(count);
	}
}