import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] arr;
	static int tmp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new int[N+1];
		for (int i=1; i<N+1; i++){
			arr[i] = i;
		}
		for (int i=0; i<M; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			change(a,b);
		}
		for (int i=1; i<N+1; i++){
			if (i != N) sb.append(arr[i] + " ");
			else sb.append(arr[i]);
		}
		System.out.println(sb);

	}
	public static void change(int i, int j){
		tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}