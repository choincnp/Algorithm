import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static final int distance = 1000;
	static Queue<Integer> queue;
	static int[][] field;
	static boolean[] visited;
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0){
			queue = new LinkedList<>();
			N = Integer.parseInt(br.readLine());
			visited = new boolean[N+2];
			field = new int[N+2][2];
			//초기 설정
			for (int i=0; i<N+2; i++){
				st = new StringTokenizer(br.readLine());
				field[i][0] = Integer.parseInt(st.nextToken());
				field[i][1] = Integer.parseInt(st.nextToken());
				if (getDistance(field[i][0], field[i][1], field[0][0], field[0][1]) <= distance){
					queue.offer(i);
					visited[i] = true;
				}
			}
			BFS();
			if (visited[N+1]) {
				sb.append("happy").append("\n");
			} else {
				sb.append("sad").append("\n");
			}
		}
		System.out.println(sb.toString());
	}
	static int getDistance(int x1, int y1, int x2, int y2){
		return Math.abs(x2-x1) + Math.abs(y2-y1);
	}

	static void BFS(){
		while (!queue.isEmpty()){
			int now = queue.poll();
			for (int i=1; i<N+2; i++){
				if (!visited[i] && getDistance(field[i][0], field[i][1], field[now][0], field[now][1]) <=distance){
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
	}
}
