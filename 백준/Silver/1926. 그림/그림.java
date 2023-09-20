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
			}
		}
		max = 0;
		count = 0;
		for (int i=0; i<N; i++){
			for (int j=0; j<M; j++){
				if (field[i][j]==1 && !visited[i][j]){
					max = Math.max(max, BFS(i, j));
					count++;
				}
			}
		}
		sb.append(count).append("\n").append(max);
		System.out.println(sb.toString());
	}

	static int BFS(int x, int y){
		queue.offer(new int[]{x, y});
		visited[x][y] = true;
		size = 1;
		while (!queue.isEmpty()){
			int[] point = queue.poll();
			for (int i=0; i<4; i++){
				int nx = point[0] + dx[i];
				int ny = point[1] + dy[i];
				if (nx >=0 && ny >= 0 && nx < N && ny < M){
					if (field[nx][ny] == 1 && !visited[nx][ny]){
						size++;
						visited[nx][ny] = true;
						queue.add(new int[]{nx, ny});
					}
				}
			}
		}
		return size;
	}
}
