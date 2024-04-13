import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] arr = new int[T];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<T; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int X = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		int count = 0;
		int start = 0;
		int end = T-1;
		while (start < end){
			if (arr[start] + arr[end] == X) {
				count++;
				end--;
			}
			else if (arr[start] + arr[end] > X) end--;
			else start++;
		}
		System.out.println(count);
	}
}