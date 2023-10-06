import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] bag = new int[N+1];
		for (int i=0; i<=N; i++){
			bag[i] = i;
		}
		while (M-- > 0){
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			for (int i = start; i<=end; i++){
				for (int j=i; j<=end; j++){
					int tmp = bag[i];
					bag[i] = bag[j];
					bag[j] = tmp;
				}
			}
		}
		for (int i=1; i<=N; i++){
			sb.append(bag[i]).append(" ");
		}
		System.out.println(sb.toString());
	}
}
