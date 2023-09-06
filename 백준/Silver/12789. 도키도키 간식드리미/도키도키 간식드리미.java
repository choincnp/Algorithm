import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int order = 1;
        for (int i=0; i<T; i++){
            int num = Integer.parseInt(st.nextToken());
            queue.add(num);
        }
        while (!queue.isEmpty()) {
            if (queue.peek() == order) {
                queue.poll();
                order++;
            }
            else if (!stack.isEmpty() && stack.peek() == order){
                stack.pop();
                order++;
            }
            else{
                stack.push(queue.poll());
            }
        }
        while (!stack.isEmpty()){
            if (stack.peek() == order){
                stack.pop();
                order++;
            }
            else{
                System.out.println("Sad");
                return;
            }
        }
        System.out.println("Nice");
    }
}
