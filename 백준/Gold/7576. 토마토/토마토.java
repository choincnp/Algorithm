import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, max;
    static int[][] field;

    static Queue<int[]> queue = new LinkedList<>();
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        field = new int[N][M];
        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++){
                field[i][j] = Integer.parseInt(st.nextToken());
                if (field[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        max = 0;
        BFS();
        for(int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                if (field[i][j] == 0) {
                    max = -1;
                    break;
                }
            }
        }
        System.out.println(max == -1 ? max : max-1);

    }
    static void BFS(){
        while (!queue.isEmpty()){
            int[] point = queue.poll();
            max = Math.max(field[point[0]][point[1]], max);
            for (int i=0; i<4; i++){
                int nx = point[0] + dx[i];
                int ny = point[1] + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M){
                    if (field[nx][ny] == 0){
                        queue.add(new int[]{nx, ny});
                        field[nx][ny] = Math.max(field[nx][ny],field[point[0]][point[1]] + 1);
                    }
                }
            }
        }
    }

}
