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
		int Max = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int tmp = 0;
		for (int i=0; i<N-2; i++){
			for (int j=i+1; j<N-1; j++){
				for (int k=j+1; k<N; k++){
					int sum = arr[i] + arr[j] + arr[k];
					if (sum <= Max){
						if (tmp < sum){
							tmp = sum;
						}
					}
				}
			}
		}
		System.out.println(tmp);
	}
}