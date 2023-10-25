import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, R, C, D, count;
	static int[][] field;
	static boolean[][] visited;
	// 북 동 남 서
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};

	static class Robot{
		int x;
		int y;
		int d;
		public Robot(int x, int y, int d){
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		field = new int[N][M];
		visited = new boolean[N][M];
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		for (int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++){
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		DFS(new Robot(R, C, D));
		System.out.println(count);
	}
	static void DFS(Robot r){
		if (field[r.x][r.y] == 1){
			return;
		} else if (field[r.x][r.y] == 0){
			field[r.x][r.y] = 2;
			count++;
		}
		int nd = r.d;
		for (int i=0; i<4; i++){
			nd = (nd + 3) % 4;
			int nx = r.x + dx[nd];
			int ny = r.y + dy[nd];
			if (field[nx][ny] > 0) continue;
			DFS(new Robot(nx, ny, nd));
			return;
		}
		DFS(new Robot(r.x - dx[r.d], r.y - dy[r.d], r.d));
		return;
	}
}
