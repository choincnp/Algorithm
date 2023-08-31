import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        int max = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, arr[i][j]);
                min = Math.min(min, arr[i][j]);
            }
        }
        int brach = Integer.MAX_VALUE;
        int height = 0;
        for (int i=min; i<=max; i++){
            int second = 0;
            int block = B;
            for (int j=0; j<N; j++){
                for (int k=0; k<M; k++){
                    if (arr[j][k]<i){
                        second += i-arr[j][k];
                        block -= i-arr[j][k];
                    }
                    else if (arr[j][k]>i){
                        second += 2*(arr[j][k]-i);
                        block += arr[j][k]-i;
                    }
                }
            }
            if (block < 0) continue;

            if (brach >= second){
                brach = second;
                height = Math.max(height, i);
            }
        }
        System.out.println(brach+" "+height);
    }
}
