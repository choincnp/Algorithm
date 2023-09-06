import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        sb.append((int)(Math.pow(2, T)-1)).append("\n");
        hanoi(T, 1, 2, 3);
        System.out.println(sb);
    }
    static void hanoi(int N, int start, int mid, int end){
        if (N==1) {
            sb.append(start).append(" ").append(end).append("\n");
            return;
        }
        hanoi(N-1, start, end, mid);
        sb.append(start).append(" ").append(end).append("\n");
        hanoi(N-1, mid, start, end);
    }
}
