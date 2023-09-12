import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    static int[][] danji;
    static boolean[][] visited;

    static ArrayList<Integer> apartment;

    static int N, count;

    //상 하 좌 우
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        danji = new int[N][N];
        visited = new boolean[N][N];
        for (int i=0; i<N; i++){
            String str = br.readLine();
            for (int j=0; j<N; j++){
                danji[i][j] = str.charAt(j) - 48;
            }
        }
        // 카운트 초기화
        apartment = new ArrayList<>();

        // DFS 실시
        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                if (!visited[i][j] && danji[i][j] == 1){
                    count = 1;
                    DFS(i, j);
                    apartment.add(count);
                }
            }
        }
        Collections.sort(apartment);
        sb.append(apartment.size()).append("\n");
        for (int i=0; i<apartment.size(); i++){
            sb.append(apartment.get(i)).append("\n");
        }
        System.out.println(sb.toString());


    }
    static void DFS(int x, int y){
        visited[x][y] = true;
        for (int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < N && ny < N){
                if (!visited[nx][ny] && danji[nx][ny]==1) {
                    DFS(nx, ny);
                    count++;
                }
            }
        }
    }
}