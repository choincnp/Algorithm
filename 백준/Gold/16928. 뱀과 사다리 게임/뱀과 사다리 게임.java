import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] field = new int[101];
	static boolean[] visited = new boolean[101];
	static Queue<Piece> queue = new LinkedList<>();

	static class Piece{
		int x;
		int count;

		public Piece(int x, int count) {
			this.x = x;
			this.count = count;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		while (N+M-->0){
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			field[i] = j;
		}
		BFS();
	}
	static void BFS(){
		queue.offer(new Piece(1,0));
		visited[1] = true;
		while (!queue.isEmpty()){
			Piece poll = queue.poll();
			if (poll.x == 100){
				System.out.println(poll.count);
				return;
			}
			for (int i=1; i<=6; i++){
				int nx = poll.x+i;
				if (nx < 101 && !visited[nx]) {
                    visited[nx] = true;
					if (field[nx] != 0){
						visited[field[nx]] = true;
						queue.offer(new Piece(field[nx], poll.count+1));
					} else {
						queue.offer(new Piece(nx, poll.count+1));
					}
				}
			}
		}
	}
}
