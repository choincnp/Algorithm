import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] field;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        field = new int[N][M];
        visited = new boolean[N][M];
        for (int i=0; i<N; i++){
            String row = br.readLine();
            for (int j=0; j<M; j++){
                field[i][j] = row.charAt(j)-48;
            }
        }
        BFS(0,0);
        System.out.println(field[N-1][M-1]);
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
                if (nx >=0 && ny >= 0 && nx < N && ny < M){
                    if (!visited[nx][ny] && field[nx][ny] != 0){
                        visited[nx][ny] = true;
                        field[nx][ny] = field[now[0]][now[1]] + 1;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
