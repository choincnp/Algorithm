import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] sum = new int[n][m];
        for (int k=0; k<2; k++){
            for (int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                for (int j=0; j<m; j++){
                    int num = Integer.parseInt(st.nextToken());
                    sum[i][j] += num;
                }
            }

        }
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                sb.append(sum[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}