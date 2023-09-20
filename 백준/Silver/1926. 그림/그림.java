import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, count, max, size;
	static Queue<int[]> queue = new LinkedList<>();
	static int[][] field;
	static boolean[][] visited;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {-1,1,0,0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		field = new int[N][M];
		visited = new boolean[N][M];
		for (int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++){
				field[i][j] = Integer.parseInt(st.nextToken());
				if (field[i][j] == 1) {
					queue.offer(new int[]{i, j});
				}
			}
		}
		count = 0;
		max = 0;
		for (int i=0; i<N; i++){
			for (int j=0; j<M; j++){
				if (!visited[i][j] && field[i][j] >= 1){
					size = 1;
					DFS(i, j);
					count++;
				}
			}
		}
		sb.append(count).append("\n").append(max);
		System.out.println(sb.toString());
	}
	static void DFS(int x, int y){
		visited[x][y] = true;
		for (int i=0; i<4; i++){
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 0 && ny >= 0 && nx < N && ny < M){
				if (!visited[nx][ny] && field[nx][ny]==1){
					size++;
					max = Math.max(max, field[nx][ny]);
					DFS(nx, ny);
				}
			}
		}
		max = Math.max(size, max);
	}

	// static void BFS(){
	// 	while (!queue.isEmpty()){
	// 		int[] point = queue.poll();
	// 		for (int i=0; i<4; i++){
	// 			int nx = point[0] + dx[i];
	// 			int ny = point[1] + dy[i];
	// 			if (nx >=0 && ny >= 0 && nx < N && ny < M){
	// 				if (field[nx][ny] == 1){
	//
	// 					field[nx][ny] = field[point[0]][point[1]] + 1;
	// 					max = Math.max(field[nx][ny], max);
	// 					queue.add(new int[]{nx, ny});
	// 				}
	// 			}
	// 		}
	// 	}
	// }
}
