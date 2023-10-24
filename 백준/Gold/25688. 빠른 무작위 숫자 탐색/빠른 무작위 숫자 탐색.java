import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static boolean[][][] visited;
	static int[][] field;
	static boolean able;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int[] bead = {0b000000, 0b000001, 0b000010, 0b000100, 0b001000, 0b010000, 0b100000};
	static StringTokenizer st;
	static int count;
	static class coordinate{
		int x;
		int y;
		//000000 ~ 111111의 수
		int bit;
		int count;

		public coordinate(int x, int y, int bit, int count) {
			this.x = x;
			this.y = y;
			this.bit = bit;
			this.count = count;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		field = new int[5][5];
		for (int i=0; i<5; i++){
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<5; j++){
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[64][5][5];
		able = false;
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		BFS(new coordinate(x, y, 0b000000, 0));
		if (able){
			System.out.println(count);
		} else {
			System.out.println("-1");
		}
	}
	static void BFS(coordinate c){
		Queue<coordinate> queue = new LinkedList<>();
		queue.offer(c);
		visited[0][c.x][c.y] = true;
		while (!queue.isEmpty()){
			coordinate now = queue.poll();
			if (now.bit == 63){
				able = true;
				count = now.count;
				return;
			}
			for (int i=0; i<4; i++){
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (nx >= 0 && ny >= 0 && nx < 5 && ny <5 && !(field[nx][ny] ==-1)){
					if (!visited[now.bit][nx][ny]){
						int newBit = addBead(now.bit, field[nx][ny]);
						queue.offer(new coordinate(nx, ny, newBit, now.count+1));
						visited[newBit][nx][ny] = true;
					}
				}
			}
		}
	}
	static int addBead(int state, int num){
		return state | bead[num];
	}
}
