import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] baechu;
    static boolean[][] visited;

    static int M, N;
    static int count;

    // 상 하 좌 우
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            baechu = new int[M][N];
            visited = new boolean[M][N];
            count = 0;
            // 배추 심기
            for (int i=0; i<num; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                baechu[x][y] = 1;
            }

            // DFS 실시
            for (int i=0; i<M; i++){
                for (int j=0; j<N; j++){
                    if (baechu[i][j] == 1 && !visited[i][j]){
                        DFS(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }

    }
    static void DFS(int x, int y){
        // 방문한것은 true 체크
        visited[x][y] = true;
        // 미방문 노드 방문
        for (int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < M && ny <N){
                if (!visited[nx][ny] && baechu[nx][ny] == 1){
                    DFS(nx, ny);
                }
            }
        }
    }
}