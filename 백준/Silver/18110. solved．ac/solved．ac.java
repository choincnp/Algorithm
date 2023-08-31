import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int exclude = (int)Math.round(t * 0.15);
        int[] arr = new int[t];
        for (int i=0; i<t; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int sum = 0;
        for (int i=exclude; i<t-exclude; i++){
            sum += arr[i];
        }
        System.out.println(Math.round((double)sum/(t-exclude*2)));
    }
}