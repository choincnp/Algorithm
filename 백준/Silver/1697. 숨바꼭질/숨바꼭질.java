import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K, next;
    static int[] field;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        field = new int[100001];
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        field[N] = 1;
        if (N == K){
            System.out.println("0");
        } else {
            BFS(N);
        }
    }
    static void BFS(int x){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        while (!queue.isEmpty()){
            int point = queue.poll();
            for (int i=0; i<3; i++){
                if (i==0){
                    next = point + 1;
                }
                else if (i==1){
                    next = point - 1;
                } else {
                    next = point * 2;
                }
                if (next == K){
                    System.out.println(field[point]);
                    return;
                }
                if (next >= 0 && next < 100001 && field[next] == 0){
                    queue.offer(next);
                    field[next] = field[point] + 1;
                }
            }
        }
    }

}
