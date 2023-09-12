import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;

    static int[][] land;
    static boolean[][] visited;

    static int N,M, count;

    //상 하 좌 우
    static int[] dx = {0,0,1,-1,-1,-1,1,1};
    static int[] dy = {1,-1,0,0,1,-1,1,-1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if (N+M == 0) break;
            land = new int[M][N];
            visited = new boolean[M][N];
            for (int i = 0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                for (int j=0; j<N; j++){
                    land[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            // count 초기화
            count = 0;

            //DFS
            for (int i=0; i<M; i++){
                for (int j=0; j<N; j++){
                    if(!visited[i][j] && land[i][j] == 1){
                        count++;
                        DFS(i, j);
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb.toString());
    }

    static void DFS(int x, int y){
        visited[x][y] = true;
        for (int i=0; i<8; i++){
            for (int j=0; j<8; j++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < M && ny < N){
                    if (!visited[nx][ny] && land[nx][ny] == 1){
                        DFS(nx, ny);
                    }
                }
            }
        }
    }
}
