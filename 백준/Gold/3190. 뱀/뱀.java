import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, K, L, count;
	static StringTokenizer st;
	static int[][] field;

	//우(1) 하(2) 좌(3) 상(4)
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static class Order{
		int sec;
		char tmp;

		public Order(int sec, char tmp) {
			this.sec = sec;
			this.tmp = tmp;
		}
	}
	static class Snake{
		int x;
		int y;
		int dir;

		public Snake(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		field = new int[N+2][N+2];
		K = Integer.parseInt(br.readLine());
		while (K-- > 0){
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			field[x][y] = 1;
		}
		L = Integer.parseInt(br.readLine());
		Queue<Order> orderQueue = new LinkedList<>();
		while (L-- > 0){
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);
			orderQueue.offer(new Order(s, c));
		}
		Deque<Snake> deque = new ArrayDeque<>();
		deque.offer(new Snake(1,1,0));
		//뱀이 있는 자리는 2, 사과는 1, 빈곳은 0으로 하자.
		field[1][1] = 2;
		while (true){
			Snake now = deque.peekLast();
			int nx = now.x + dx[now.dir];
			int ny = now.y + dy[now.dir];
			// 벽에 박거나 몸통에 박아도 일단 시간은 가야함
			count++;
			if (!canMove(nx, ny)) break;
			//사과인지 빈 공간인지 구분 안해도 되는게, 빈 공간이라면 그냥 꼬리하나 빼주면 된다.
			if (field[nx][ny] == 0){
				Snake old = deque.peekFirst();
				field[old.x][old.y] = 0;
				deque.poll();
			}
			field[nx][ny] = 2;
			if (!orderQueue.isEmpty() && count == orderQueue.peek().sec){
				deque.offer(new Snake(nx, ny, changeDir(now.dir, orderQueue.peek().tmp)));
				orderQueue.poll();
			} else {
				deque.offer(new Snake(nx, ny, now.dir));
			}
		}
		System.out.println(count);
	}
	static boolean canMove(int x, int y){
		if (x < 1 || y < 1 || x > N || y > N || field[x][y] == 2) return false;
		else return true;
	}
	static int changeDir(int i, char c){
		if (c == 'L' && i == 0) return 3;
		else if (c=='D' && i==3) return 0;
		return c=='L' ? i-1 : i+1;
	}
}
