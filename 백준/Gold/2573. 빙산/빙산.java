import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, count;

	static int[][] field;

	static boolean[][] visited;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		field = new int[N][M];
		for (int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++){
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int year = 0;

		while (true){
			visited = new boolean[N][M];
			count = 0;
			for (int i=0; i<N; i++){
				for (int j=0; j<M; j++){
					if (!visited[i][j] && field[i][j] > 0){
						DFS(i, j);
						count++;
					}
				}
			}

			if (count == 0){
				year = 0;
				break;
			} else if (count >= 2){
				break;
			}
			BFS();
			year++;
		}

		System.out.println(year);

	}
	static void DFS(int x, int y){
		visited[x][y] = true;
		for (int i=0; i<4; i++){
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >=0 && ny >= 0 && nx < N && ny < M){
				if (!visited[nx][ny] && field[nx][ny] > 0){
					DFS(nx, ny);
				}
			}
		}
	}
	static void BFS(){
		visited = new boolean[N][M];
		Queue<int[]> queue = new LinkedList<>();
		for (int i=0; i<N; i++){
			for (int j=0; j<M; j++){
				if (field[i][j] > 0){
					queue.offer(new int[]{i, j});
					visited[i][j] = true;
				}
			}
		}

		while (!queue.isEmpty()){
			int[] point = queue.poll();
			int count = 0;
			for (int i=0; i<4; i++){
				int nx = point[0] + dx[i];
				int ny = point[1] + dy[i];
				if (nx >= 0 && ny >= 0 && nx < N && ny < M){
					if (!visited[nx][ny] && field[nx][ny] == 0){
						count++;
					}
				}
			}
			if (field[point[0]][point[1]] >= count){
				field[point[0]][point[1]] -= count;
			} else {
				field[point[0]][point[1]] = 0;
			}
		}

	}
}
