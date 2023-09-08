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
        Deque<int[]> deque = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        // Deque에 순번과 풍선번호 기입, [1,3], [2,2], [3,1]등으로 들어감
        for (int i=0; i<T; i++){
            int[] arr = {i+1, Integer.parseInt(st.nextToken())};
            deque.add(arr);
        }
        while (deque.size()>1){
            // 1번과 순서 꺼낸다.
            int[] order = deque.pollFirst();
            sb.append(order[0]).append(" ");
            if (order[1] > 0){
                while (order[1]-->1){
                    deque.addLast(deque.pollFirst());
                }
            } else{
                while (order[1]++<0){
                    deque.addFirst(deque.pollLast());
                }
            }
        }
        sb.append(deque.pollFirst()[0]);
        System.out.println(sb.toString());
    }
}
