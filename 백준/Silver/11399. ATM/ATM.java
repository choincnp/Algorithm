import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int[] sum = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for (int i=0; i<N; i++){
			int insert_point = i;
			int insert_value = arr[i];
			for (int j=i-1; j>=0; j--){
				if (arr[j] < arr[i]){
					insert_point = j+1;
					break;
				}
				if (j==0) insert_point = 0;
			}
			for (int j=i; j>insert_point; j--){
				arr[j] = arr[j-1];
			}
			arr[insert_point] = insert_value;
		}
		sum[0] = arr[0];
		for (int i=1; i<N; i++){
			sum[i] = sum[i-1] + arr[i];
		}
		int result = Arrays.stream(sum).map(i -> i).sum();
		System.out.println(result);
	}
}