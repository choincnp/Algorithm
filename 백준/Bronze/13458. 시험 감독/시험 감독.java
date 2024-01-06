import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int A = Integer.parseInt(br.readLine());
        int[] array = new int[A];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<A; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        long sum = 0;
        for (int i=0; i<A; i++){
            if (B >= array[i]){
                sum += 1;
            } else {
                sum += 1;
                array[i] -= B;
                if ((array[i]%C) == 0){
                    sum += (array[i]/C);
                } else {
                    sum += (array[i]/C) + 1;
                }
            }
        }
        System.out.println(sum);
    }
}