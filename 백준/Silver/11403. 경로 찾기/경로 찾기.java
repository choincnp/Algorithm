import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[][] field = new int[N][N];
        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++){
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp != 0){
                    field[i][j] = tmp;
                } else {
                    field[i][j] = 999999;
                }
            }
        }
        for (int k = 0; k<N; k++){
            for (int i = 0; i<N; i++){
                for (int j=0; j<N; j++){
                    field[i][j] = Math.min(field[i][j], field[i][k] + field[k][j]);
                }
            }
        }
        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                if (field[i][j] == 999999){
                    sb.append(0).append(" ");
                } else {
                    sb.append(1).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}