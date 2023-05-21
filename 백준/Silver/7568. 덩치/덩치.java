import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt((st.nextToken()));
		int[][] pocket = new int[N][2];
		for (int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			pocket[i][0] = Integer.parseInt(st.nextToken());
			pocket[i][1] = Integer.parseInt(st.nextToken());
		}
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<N; i++){
			int rank = 1;
			for (int j=0; j<N; j++){
				if (pocket[i][0] < pocket[j][0] && pocket[i][1] < pocket[j][1]){
					rank++;
				}
			}
			if (i == N - 1) {
				sb.append(rank);
			} else {
				sb.append(rank).append(" ");
			}
		}
		System.out.println(sb);
	}
}