import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, eat, size = 2, move;
	static StringTokenizer st;
	static int[][] field;
	static boolean[][] visited;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		field = new int[N][N];
		Shark shark = new Shark(0,0,0);
		for (int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++){
				field[i][j] = Integer.parseInt(st.nextToken());
				if (field[i][j] == 9){
					shark.r = i;
					shark.c = j;
					field[i][j] = 0;
				}
			}
		}
		BFS(shark);
		System.out.println(move);
	}
	static void BFS(Shark shark){
		while (true){
			PriorityQueue<Shark> pQueue = new PriorityQueue<>(
				(o1, o2) -> o1.dist != o2.dist ? o1.dist - o2.dist : o1.r != o2.r ? o1.r - o2.r : o1.c - o2.c
			);
			visited = new boolean[N][N];
			shark.dist = 0;
			pQueue.offer(shark);
			visited[shark.r][shark.c] = true;
			boolean check = false;
			while (!pQueue.isEmpty()){
				shark = pQueue.poll();
				if (field[shark.r][shark.c] != 0 && field[shark.r][shark.c] < size){
					field[shark.r][shark.c] = 0;
					eat++;
					move += shark.dist;
					check = true;
					break;
				}
				for (int i=0; i<4; i++){
					int ny = shark.r + dy[i];
					int nx = shark.c + dx[i];
					if (nx >= 0 && ny >= 0 && nx< N && ny < N && !visited[ny][nx] && field[ny][nx] <= size){
						pQueue.offer(new Shark(ny, nx, shark.dist+1));
						visited[ny][nx] = true;
					}
				}
			}
			if (!check) break;
			if (eat == size){
				size++;
				eat = 0;
			}
		}
	}
	static class Shark{
		int r;
		int c;
		int dist;
		public Shark(int r, int c, int dist){
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
	}
}