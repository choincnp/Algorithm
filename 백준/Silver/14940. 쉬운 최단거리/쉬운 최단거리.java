import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, x, y;
    static int[][] field;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        field = new int[N][M];
        visited = new boolean[N][M];
        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++){
                int num = Integer.parseInt(st.nextToken());
                field[i][j] = num;
                if (num == 2){
                    x = i;
                    y = j;
                }
            }
        }
        field[x][y] = 0;
        BFS(x, y);
        for (int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                if (!visited[i][j] && field[i][j] != 0){
                    field[i][j] = -1;
                }
                sb.append(field[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    static void BFS(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()){
            int[] now = queue.poll();
            for (int i=0; i<4; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M){
                    if (!visited[nx][ny] && field[nx][ny] > 0){
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                        field[nx][ny] = field[now[0]][now[1]] + 1;
                    }
                }
            }
        }

    }

}
