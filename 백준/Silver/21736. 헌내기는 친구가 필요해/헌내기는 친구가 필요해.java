import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, count;
	static char[][] campus;
	static boolean[][] visited;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};

	static Queue<int[]> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		campus = new char[N][M];
		visited = new boolean[N][M];
		for (int i=0; i<N; i++){
			String row = br.readLine();
			for (int j=0; j<M; j++){
				campus[i][j] = row.charAt(j);
				if (campus[i][j] == 'I') {
					visited[i][j] = true;
					queue.offer(new int[]{i, j});
				}
			}
		}
		count = 0;
		BFS();
		if (count == 0){
			System.out.println("TT");
		} else {
			System.out.println(count);
		}
	}
	static void BFS(){
		while(!queue.isEmpty()){
			int[] point = queue.poll();
			for (int i=0; i<4; i++){
				int nx = point[0] + dx[i];
				int ny = point[1] + dy[i];
				if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny]){
					if (campus[nx][ny] == 'O') {
						queue.add(new int[]{nx, ny});
						visited[nx][ny] = true;
					} else if (campus[nx][ny] == 'P'){
						queue.add(new int[]{nx, ny});
						visited[nx][ny] = true;
						count++;
					}
				}
			}
		}
	}
}
