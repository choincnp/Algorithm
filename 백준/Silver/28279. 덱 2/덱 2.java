import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new LinkedList<>();
        int T = Integer.parseInt(br.readLine());
        while (T -- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command){
                case "1":
                    int first = Integer.parseInt(st.nextToken());
                    deque.addFirst(first);
                    break;
                case "2":
                    int last = Integer.parseInt(st.nextToken());
                    deque.addLast(last);
                    break;
                case "3":
                    if (!deque.isEmpty()){
                        sb.append(deque.poll()).append("\n");
                    }
                    else {sb.append("-1").append("\n");
                    }
                    break;
                case "4":
                    if (!deque.isEmpty()){
                        sb.append(deque.pollLast()).append("\n");
                    }
                    else{
                        sb.append("-1").append("\n");
                    }
                    break;
                case "5":
                    sb.append(deque.size()).append("\n");
                    break;
                case "6":
                    sb.append(deque.isEmpty() ? "1" : "0").append("\n");
                    break;
                case "7":
                    if (!deque.isEmpty()){
                        sb.append(deque.peekFirst()).append("\n");
                    }
                    else {
                        sb.append("-1").append("\n");
                    }
                    break;
                case "8":
                    if (!deque.isEmpty()){
                        sb.append(deque.peekLast()).append("\n");
                    }
                    else {
                        sb.append("-1").append("\n");
                    }
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}