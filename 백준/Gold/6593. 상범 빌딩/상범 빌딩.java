import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int L, R, C;
	static int[][][] building;
	static int[] dx = {0,0,0,0,1,-1};
	static int[] dy = {0,0,1,-1,0,0};
	static int[] dz = {1,-1,0,0,0,0};
	static Queue<int[]> queue = new LinkedList<>();
	static Queue<int[]> dest = new LinkedList<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true){
			StringTokenizer st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			if (L == R && R == C && C == 0){
				break;
			}
			building = new int[L][R][C];
			for (int h=0; h<L; h++){
				for (int i=0; i<R; i++){
					String row = br.readLine();
					for (int j=0; j<C; j++){
						char c = row.charAt(j);
						if (c == 'S'){
							queue.offer(new int[]{h,i,j});
							building[h][i][j] = 0;
						} else if (c == '#'){
							building[h][i][j] = -1;
						} else if (c == '.'){
							building[h][i][j] = 0;
						} else {
							building[h][i][j] = 0;
							dest.offer(new int[]{h,i,j});
						}
					}
				}
				br.readLine();
			}
			BFS();
			int min = Integer.MAX_VALUE;
			while (!dest.isEmpty()){
				int[] point = dest.poll();
				if (building[point[0]][point[1]][point[2]] != 0){
					min = Math.min(min, building[point[0]][point[1]][point[2]]);
				}
			}
			if (min == Integer.MAX_VALUE){
				sb.append("Trapped!").append("\n");
			} else {
				sb.append("Escaped in ").append(min).append(" minute(s).").append("\n");
			}

		}
		System.out.println(sb.toString());
	}
	static void BFS(){
		while (!queue.isEmpty()){
			int[] point = queue.poll();
			for (int i=0; i<6; i++){
				int nx = point[1] + dx[i];
				int ny = point[2] + dy[i];
				int nz = point[0] + dz[i];
				if (nx >= 0 && ny >= 0 && nz >= 0 && nx < R && ny < C && nz < L){
					if (building[nz][nx][ny] == 0){
						building[nz][nx][ny] = building[point[0]][point[1]][point[2]] + 1;
						queue.offer(new int[]{nz, nx, ny});
					}
				}
			}
		}
	}
}
