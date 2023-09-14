import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static char[][] field;
    static boolean[][] visited;
    static int N, count;

    static boolean rg;

    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        field = new char[N][N];
        for (int i=0; i<N; i++){
            String row = br.readLine();
            for (int j=0; j<N; j++){
                field[i][j] = row.charAt(j);
            }
        }
        //DFS
        for (int c=0; c<2; c++){
            visited = new boolean[N][N];
            count = 0;
            for (int i=0; i<N; i++){
                for (int j=0; j<N; j++){
                    char color = field[i][j];
                    if (!visited[i][j]){
                        count++;
                        DFS(i, j, color);
                    }
                }
            }
            sb.append(count).append(" ");
            rg = true;
        }
        System.out.println(sb.toString());
    }
    static void DFS(int x, int y, char color) {
        visited[x][y] = true;
        for (int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >=0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]){
                //적녹색맹이 아닐 경우
                if (!rg && field[nx][ny] == color) {
                    DFS(nx, ny, color);
                }

                //적녹색맹일경우
                else if (rg){
                    if (color == 'R' || color == 'G'){
                        if (field[nx][ny] == 'R' || field[nx][ny] == 'G'){
                            DFS(nx, ny, color);
                        }
                    }
                    else{
                        if (field[nx][ny] == color){
                            DFS(nx, ny, color);
                        }
                    }
                }
            }
        }

    }
}