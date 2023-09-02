import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        arr = new long[T+1];
        Arrays.fill(arr, -1);
        arr[0] = 0;
        arr[1] = 1;
        System.out.println(fibonacci(T));
    }
    static long fibonacci(int N){
        if (arr[N] == -1){
            arr[N] = fibonacci(N-1) + fibonacci(N-2);
        }
        return arr[N];
    }
}