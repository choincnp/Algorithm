import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int T, I, a, b, c, d;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[][] field;
	//상 하 좌 우
	static int[] dx = {-1,1,2,2,1,-1,-2,-2};
	static int[] dy = {2,2,1,-1,-2,-2,-1,1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int i=0; i<T; i++){
			I = Integer.parseInt(br.readLine());
			field = new int[I][I];
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			c = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			BFS();
			sb.append(field[c][d]).append("\n");
		}
		System.out.println(sb.toString());
	}
	static void BFS(){
		if (a==c && b==d){
			return;
		}
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{a,b});
		while (!queue.isEmpty()){
			int[] point = queue.poll();
			for (int i=0; i<8; i++){
				int nx = point[0] + dx[i];
				int ny = point[1] + dy[i];
				if (nx >= 0 && ny >= 0 && nx < I && ny < I){
					if (field[nx][ny] == 0){
						field[nx][ny] = field[point[0]][point[1]] + 1;
						queue.offer(new int[]{nx, ny});
					} else {
						field[nx][ny] = Math.min(field[nx][ny], field[point[0]][point[1]]+1);
					}
				}
			}
		}
	}
}
