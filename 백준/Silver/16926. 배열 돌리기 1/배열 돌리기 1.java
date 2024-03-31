import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] field = new int[N][M];
		for (int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++){
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//회전
		for (int i=0; i<N; i++){
			for (int j=0; j<M; j++){
				//껍질 계산
				int d = Math.min(Math.min(Math.min(i, N-i-1), j), M-j-1);
				//최소거리 계산
				int r = R % (2 * (N - 2*d) + 2 * (M - 2*d) - 4);
				//새로운 좌표
				int ni = i;
				int nj = j;
				// 회전 시작
				while (r > 0) {
					if (nj == d) {
						int minMove = Math.min(r, ni - d);
						ni -= minMove;
						r -= minMove;
					}
					if (ni == d) {
						int minMove = Math.min(r, M - 1 - nj - d);
						nj += minMove;
						r -= minMove;
					}
					if (ni == N - 1 - d) {
						int minMove = Math.min(r, nj - d);
						nj -= minMove;
						r -= minMove;
					}
					if (nj == M - 1 - d) {
						int minMove = Math.min(r, N - 1 - ni - d);
						ni += minMove;
						r -= minMove;
					}
				}
				sb.append(field[ni][nj]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
