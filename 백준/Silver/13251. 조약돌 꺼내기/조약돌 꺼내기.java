import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int M, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] d = new int[51];
        M = Integer.parseInt(br.readLine());
        double[] prob = new double[51];
        int T = 0;
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<M; i++){
            d[i] = Integer.parseInt(st.nextToken());
            T += d[i];
        }
        K = Integer.parseInt(br.readLine());
        double answer = 0.0d;
        for (int i=0; i<M; i++){
            if (d[i] >= K) {
                prob[i] = 1.0;
                for (int j=0; j<K; j++){
                    prob[i] *= (double) (d[i] - j) / (T - j);
                }
            }
            answer += prob[i];
        }
        System.out.println(answer);
    }
}