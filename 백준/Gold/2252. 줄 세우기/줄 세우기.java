import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static int N, M;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for (int i=0; i<=N; i++){
            arr.add(new ArrayList<>());
        }
        int[] indegree = new int[N+1];
        for (int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            arr.get(S).add(E);
            indegree[E]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i=1; i<=N; i++){
            if (indegree[i] == 0){
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()){
            int now = queue.poll();
            System.out.print(now + " ");
            for (int next : arr.get(now)){
                indegree[next]--;
                if (indegree[next] == 0){
                    queue.offer(next);
                }
            }
        }
    }
}