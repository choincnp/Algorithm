import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, H;

	static int[][][] field;

	static Queue<int[]> queue = new LinkedList<>();

	static int[] dx = {0,0,0,0,-1,1};
	static int[] dy = {0,0,1,-1,0,0};
	static int[] dz = {-1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		field = new int[N][M][H];
		for (int h=0; h<H; h++){
			for (int i=0; i<N; i++){
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<M; j++){
					field[i][j][h] = Integer.parseInt(st.nextToken());
					if (field[i][j][h] == 1){
						queue.add(new int[]{i,j,h});
					}
				}
			}
		}
		int max = 0;
		BFS();


	}
	static void BFS(){
		int count = 0;
		while (!queue.isEmpty()){
			int[] point = queue.poll();
			for (int i=0; i<6; i++){
				int nx = point[0] + dx[i];
				int ny = point[1] + dy[i];
				int nz = point[2];
				if (i < 2){
					nz = point[2] + dz[i];
				}
				if (nx >= 0 && ny >= 0 && nz >= 0 && nx < N && ny < M && nz < H){
					if (field[nx][ny][nz] == 0){
						field[nx][ny][nz] = field[point[0]][point[1]][point[2]] + 1;
						count = Math.max(count, field[nx][ny][nz]);
						queue.offer(new int[]{nx,ny,nz});
					}
				}
			}

		}
		if (check()){
			if (count == 0){
				System.out.println(count);
			} else{
				System.out.println(count -1);
			}
		} else {
			System.out.println("-1");
		}
	}

	static boolean check(){
		for (int i=0; i<H; i++){
			for (int j=0; j<N; j++){
				for (int k=0; k<M; k++){
					if (field[j][k][i] == 0){
						return false;
					}
				}
			}
		}
		return true;
	}

}
