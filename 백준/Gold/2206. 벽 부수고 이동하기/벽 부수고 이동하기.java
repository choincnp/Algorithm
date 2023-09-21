import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] field;
	static boolean[][][] visited;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};

	static class Node{
		int x;
		int y;
		int count;
		int wall;
		public Node(int x, int y, int count, int wall) {
			this.x = x;
			this.y = y;
			this.count = count;
			this.wall = wall;
		}
	}

	public static void main(String[] args) throws IOException {
		// 1. DFS로 최단경로 있는지 확인
		// 2. 벽 확인
		// 3. BFS로 경로탐색
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		field = new int[N][M];
		for (int i=0; i<N; i++){
			String row = br.readLine();
			for (int j=0; j<M; j++){
				field[i][j] = row.charAt(j)-'0';
			}
		}
		visited = new boolean[N][M][2];
		System.out.println(BFS());
	}

	static int BFS(){
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(0,0,1,0));
		visited[0][0][0] = true;
		visited[0][0][1] = true;
		while (!queue.isEmpty()){
			Node point = queue.poll();
			if (point.x == N-1 && point.y == M-1){
				return point.count;
			}
			for (int i=0; i<4; i++){
				int nx = point.x + dx[i];
				int ny = point.y + dy[i];
				if (nx >=0 && ny >= 0 && nx < N && ny < M){
					if (field[nx][ny] == 0){
						if (!visited[nx][ny][point.wall]){
							queue.offer(new Node(nx, ny, point.count+1, point.wall));
							visited[nx][ny][point.wall] = true;
						}
					}
					else if (field[nx][ny] == 1){
						if (point.wall == 0 && !visited[nx][ny][1]){
							queue.offer(new Node(nx, ny, point.count+1, point.wall+1));
							visited[nx][ny][1] = true;
						}
					}
				}
			}
		}
		return -1;
	}
}