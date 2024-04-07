import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	/*
	 * 집 배열 field, 방문 배열 visited 주어져야 함
	 * 델타배열로 nx, ny 만들어야함
	 * T를 만나면 count++
	 * 최소 거리 아니지만, K 넘으면 return
	 */
	static char[][] field;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0,0,-1,1};
	static int R, C, K, count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		field = new char[R][C];
		visited = new boolean[R][C];
		for (int i=0; i<R; i++){
			String row = br.readLine();
			for (int j=0; j<C; j++){
				field[i][j] = row.charAt(j);
			}
		}
		visited[R-1][0] = true;
		wayBackHome(0, R-1, 1);
		System.out.println(count);
	}
	static void wayBackHome(int x, int y, int depth){
		if (x == C-1 && y == 0 && depth == K) {
			count++;
		}
		for (int i=0; i<4; i++){
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >=0 && ny >= 0 && nx < C && ny < R && field[ny][nx] != 'T'){
				if (!visited[ny][nx]){
					visited[ny][nx] = true;
					wayBackHome(nx, ny, depth + 1);
					visited[ny][nx] = false;
				}
			}
		}
	}
}
