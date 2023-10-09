import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] solution;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		solution = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++){
			solution[i] = Integer.parseInt(st.nextToken());
		}
		int start = 0;
		int end = N-1;
		int al = 0;
		int ar = 0;
		int min = Integer.MAX_VALUE;
		while (start < end){
			int sum = solution[start] + solution[end];
			if (min > Math.abs(sum)){
				min = Math.abs(sum);
				al = start;
				ar = end;
			} else if (sum == 0){
				break;
			}
			if (sum > 0){
				end--;
			} else {
				start++;
			}
		}
		sb.append(solution[al]).append(" ").append(solution[ar]);
		System.out.println(sb.toString());
	}
}
