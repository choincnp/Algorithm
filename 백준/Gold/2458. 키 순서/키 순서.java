import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static StringTokenizer st;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] key = new int[N+1][N+1];
        for (int i=1; i<=N; i++){
            for (int j=1; j<=N; j++){
                if (i==j) continue;
                else key[i][j] = 10000001;
            }
        }
        while (M-- > 0){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            key[S][E] = 1;
        }
        for (int k = 1; k <= N; k++){
            for (int i=1; i<=N; i++){
                for (int j=1; j<=N; j++){
                    key[i][j] = Math.min(key[i][j], key[i][k] + key[k][j]);
                }
            }
        }
        int answer = 0;
        for (int i=1; i<=N; i++){
            int cnt = 0;
            for (int j=1; j<=N; j++){
                if (key[i][j] != 10000001 || key[j][i] != 10000001){
                    cnt++;
                }
            }
            if (cnt == N) answer++;
        }
        System.out.println(answer);
    }
}