import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] tile;
    static boolean[][] visited;

    static int N, M;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //세로
        N = Integer.parseInt(st.nextToken());
        //가로
        M = Integer.parseInt(st.nextToken());
        tile = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                tile[i][j] = str.charAt(j);
            }
        }

        int count = 0;
        //DFS 실시
        for (int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                if (!visited[i][j]){
                    DFS(i, j);
                    count++;
                }
            }
        }
        System.out.println(count);

    }
    static void DFS(int x, int y){
        //방문 노드 체크
        visited[x][y] = true;
        //미방문 노드 방문
        if(tile[x][y] == '-'){
            y++;
            if (y < M){
                if (!visited[x][y] && tile[x][y] == '-'){
                    DFS(x, y);
                }
            }
        } else{
            x++;
            if (x < N){
                if (!visited[x][y] && tile[x][y] == '|'){
                    DFS(x, y);
                }
            }
        }
    }
}
