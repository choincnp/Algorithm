import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int F, S, G, U, D;
	static int[] building;
	static int[] button;
	static long count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		building = new int[F+1];
		button = new int[]{U, -D};
		if (BFS(S)){
			System.out.println(building[G]);
		} else {
			System.out.println("use the stairs");
		}
	}
	static boolean BFS(int x){
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(x);
		building[x] = 0;
		while (!queue.isEmpty()){
			int now = queue.poll();
			if (now == G){
				return true;
			}
			for (int i=0; i<2; i++){
				int next = now + button[i];
				if (next >= 1 && next <= F && building[next] == 0 && next!=now){
					queue.offer(next);
					building[next] = building[now] + 1;
				}
			}
		}
		return false;
	}
}
