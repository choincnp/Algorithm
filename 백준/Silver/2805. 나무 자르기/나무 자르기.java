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
        int[] tree = new int[N];
        st = new StringTokenizer(br.readLine());
        int min = 0;
        int max = 0;
        for (int i=0; i<N; i++){
            tree[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, tree[i]);
        }
        while (min < max){
            int mid = (min + max) / 2;
            long sum = 0;
            for (int i : tree){
                if (i - mid > 0) sum += (i-mid);
            }
            if (sum < M) max = mid;
            else min = mid + 1;
        }
        System.out.println(min - 1);
    }
}
