import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;
	static boolean flag;
	static int[][] field;
	static boolean[][] visited;
	static int N, M;
	//상 하 좌 우 좌상 좌하 우상 우하
	static int[] dx = {0, 0, -1, 1, -1, -1, 1, 1};
	static int[] dy = {-1, 1, 0, 0, -1, 1, 1, -1};
	static class Point{
		int x;
		int y;
		int height;
		public Point(int x, int y, int height){
			this.x = x;
			this.y = y;
			this.height = height;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		field = new int[N][M];
		visited = new boolean[N][M];
		for (int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++){
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int count = 0;
		for (int i=0; i<N; i++){
			for (int j=0; j<M; j++){
				if (!visited[i][j] && field[i][j] != 0){
					flag = true;
					DFS(i, j);
					if (flag){
						count++;
					}
				}
			}
		}
		System.out.println(count);
	}
	static void DFS(int x, int y){
		visited[x][y] = true;
		for (int i=0; i<8; i++){
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && ny >= 0 && nx < N && ny < M){
				if (field[x][y] < field[nx][ny]){
					flag = false;
				}
				if (!visited[nx][ny] && field[nx][ny] == field[x][y]){
					DFS(nx, ny);
				}
			}
		}
	}
}
