import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static char[][] field;
    static boolean[] visited;
    static int R, C, count, max;

    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        field = new char[R][C];
        for (int i=0; i<R; i++){
            String row = br.readLine();
            for (int j=0; j<C; j++){
                field[i][j] = row.charAt(j);
            }
        }

        //DFS
        max = 1;
        visited = new boolean[26];
        count = 1;
        DFS(0,0,count);
        System.out.println(max);
    }
    static void DFS(int x, int y, int count) {
        visited[field[x][y]-65] = true;
        max = Math.max(max, count);
        for (int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < R && ny < C){
                if (!visited[field[nx][ny]-65]){
                    DFS(nx, ny, count+1);
                }
            }
        }
        visited[field[x][y]-65] = false;
    }
}