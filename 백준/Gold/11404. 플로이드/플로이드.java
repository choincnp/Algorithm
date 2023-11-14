import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static StringTokenizer st;
    static int N, M, S, E, W;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        int[][] schedule = new int[N+1][N+1];
        for (int i=1; i<=N; i++){
            for (int j=1; j<=N; j++){
                if (i == j) continue;
                else schedule[i][j] = 100000001;
            }
        }
        while (M -- > 0){
            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            if (schedule[S][E] > W){
                schedule[S][E] = W;
            }
        }
        for (int K = 1; K<=N; K++){
            for (int S = 1; S<= N; S++){
                for (int E = 1; E <= N; E++){
                    if (schedule[S][E] > schedule[S][K] + schedule[K][E]){
                        schedule[S][E] = schedule[S][K] + schedule[K][E];
                    }
                }
            }
        }
        for (int i=1; i<=N; i++){
            for (int j=1; j<=N; j++){
                if (schedule[i][j] == 100000001){
                    sb.append(0).append(" ");
                } else {
                    sb.append(schedule[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}