import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int[] stackOrQueue = new int[T];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<T; i++){
            stackOrQueue[i] = Integer.parseInt(st.nextToken());
        }
        Deque<Integer> deque = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<T; i++){
            int num = Integer.parseInt(st.nextToken());
            if (stackOrQueue[i] == 0) deque.add(num);
        }
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (N-- > 0){
            int M = Integer.parseInt(st.nextToken());
            deque.addFirst(M);
            sb.append(deque.pollLast()).append(" ");
        }
        System.out.println(sb.toString());
    }
}
