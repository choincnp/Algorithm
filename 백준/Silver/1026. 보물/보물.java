import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		Integer[] arr = new Integer[N];
		Integer[] order = new Integer[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++){
			order[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		Arrays.sort(order, Collections.reverseOrder());
		int sum = 0;
		for (int i=0; i<N; i++){
			sum += arr[i]*order[i];
		}
		System.out.println(sum);
	}
}
