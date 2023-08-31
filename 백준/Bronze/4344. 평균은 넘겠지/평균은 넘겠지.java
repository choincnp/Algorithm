import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int[] arr = new int[m];
            int sum = 0;
            int count = 0;
            for (int j=0; j<m; j++){
                arr[j] = Integer.parseInt(st.nextToken());
                sum += arr[j];
            }
            double avg = (double)sum/m;
            for (int j=0; j<m; j++){
                if (arr[j]>avg) count++;
            }
            System.out.println(String.format("%.3f", (double)count/m*100)+"%");
        }

    }
}