import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i=0; i<N; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int count = 0;
		for (int i=0; i<N; i++){
			int sum = arr[i];
			int start_idx = 0;
			int end_idx = N-1;
			while (end_idx > start_idx){
				if (sum == arr[end_idx] + arr[start_idx]){
					if( start_idx != i && end_idx != i){
						count++;
						break;
					}
					else if (start_idx == i){
						start_idx++;
					}
					else if (end_idx == i){
						end_idx--;
					}
				}
				else if (sum > arr[end_idx] + arr[start_idx]){
					start_idx++;
				}
				else{
					end_idx--;
				}
			}
		}
		System.out.println(count);
	}
}