	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.util.Arrays;
	import java.util.LinkedList;
	import java.util.Queue;
	import java.util.StringTokenizer;

	public class Main {
		static int N, M, max;
		static int[][] field;
		static int[][] copiedField;
		static int[] dx = {0,0,-1,1};
		static int[] dy = {1,-1,0,0};

		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			field = new int[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					field[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			DFS(0);
			System.out.println(max);

		}
		static void DFS(int wall){
			if (wall == 3){
				BFS();
				return;
			}
			for (int i=0; i<N; i++){
				for (int j=0; j<M; j++){
					if (field[i][j] == 0){
						field[i][j] = 1;
						DFS(wall+1);
						field[i][j] = 0;
					}
				}
			}
		}

		static void BFS(){
			Queue<int[]> queue = new LinkedList<>();
			copiedField = new int[N][M];
			int count = 0;
			for (int i=0; i<N; i++){
				for (int j=0; j<M; j++){
					copiedField[i][j] = field[i][j];
					if (field[i][j] == 2){
						queue.offer(new int[]{i, j});
					}
				}
			}

			while (!queue.isEmpty()){
				int[] point = queue.poll();
				for (int i=0; i<4; i++){
					int nx = point[0] + dx[i];
					int ny = point[1] + dy[i];
					if (nx>=0 && ny >= 0 && nx < N && ny < M){
						if (copiedField[nx][ny] == 0){
							copiedField[nx][ny] = 2;
							queue.offer(new int[]{nx, ny});
						}
					}
				}
			}

			for (int i=0; i<N; i++){
				for (int j=0; j<M; j++){
					if (copiedField[i][j] == 0){
						count++;
					}
				}
			}
			max = Math.max(max, count);
		}
	}
