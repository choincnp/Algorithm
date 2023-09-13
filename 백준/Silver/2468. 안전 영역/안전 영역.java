import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    static StringTokenizer st;

    static int[][] land;
    static boolean[][] visited;

    static int N, count;

    //상 하 좌 우
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        land = new int[N][N];
        int maxHeight = 0;
        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++){
                int h = Integer.parseInt(st.nextToken());
                land[i][j] = h;
                maxHeight = Math.max(maxHeight, h);
            }
        }
        int max = 0;
        //DFS
        for (int i=0; i<maxHeight; i++){
            count = 0;
            visited = new boolean[N][N];
            for (int j=0; j<N; j++){
                for (int k=0; k<N; k++){
                    if (!visited[j][k] && land[j][k] > i){
                        count++;
                        DFS(j, k, i);
                    }
                }
            }
            max = Math.max(max, count);
        }

        System.out.println(max);

    }

    static void DFS(int x, int y, int height){
        visited[x][y] = true;
        for (int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >=0 && ny >= 0 && nx < N && ny < N){
                if (!visited[nx][ny] && (land[nx][ny] > height)){
                    DFS(nx, ny, height);
                }
            }
        }
    }
}