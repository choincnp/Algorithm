import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static Deque<Integer> deque;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-->0){
            String[] commandSet = br.readLine().split("");
            int size = Integer.parseInt(br.readLine());
            deque = new ArrayDeque<>();
            StringTokenizer st = new StringTokenizer(br.readLine(), "(?<=\\]),\\s?(?=\\[)");
            while (st.hasMoreTokens()){
                deque.add(Integer.parseInt(st.nextToken()));
            }
            boolean right = true;
            boolean error = false;
            for (String command : commandSet){
                if (command.equals("R")) {
                    right = !right;
                }
                else {
                    if (deque.isEmpty()){
                        error = true;
                        break;
                    }
                    if (right) deque.pollFirst();
                    else deque.pollLast();
                }
            }
            if (!error){
                sb.append("[");
                if (right) {
                    while (deque.size()>1){
                        sb.append(deque.pollFirst()).append(",");
                    }
                } else {
                    while (deque.size()>1){
                        sb.append(deque.pollLast()).append(",");
                    }
                }
                if (deque.size() != 0){
                    sb.append(deque.getFirst());
                }
                sb.append("]\n");
            } else {
                sb.append("error").append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
