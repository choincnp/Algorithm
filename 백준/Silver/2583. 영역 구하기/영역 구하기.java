import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static int[][] field;
    static boolean[][] visited;
    static int N, M, count;

    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        field = new int[N][M];
        visited = new boolean[N][M];
        for (int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            for (int j = a; j<c; j++){
                for (int k=b; k<d; k++){
                    field[k][j] = 1;
                }
            }
        }
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                if (!visited[i][j] && field[i][j]==0){
                    count = 1;
                    DFS(i, j);
                    answer.add(count);
                }
            }
        }
        Collections.sort(answer);
        sb.append(answer.size()).append("\n");
        for (int i : answer){
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString());
    }
    static void DFS(int x, int y){
        visited[x][y] = true;
        for (int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < N && ny < M){
                if (!visited[nx][ny] && field[nx][ny] == 0){
                    DFS(nx, ny);
                    count++;
                }
            }
        }
    }
}
