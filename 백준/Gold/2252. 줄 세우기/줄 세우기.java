import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static int N, M;
    static ArrayList<ArrayList<Integer>> A;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[] indegree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new ArrayList<>();
        indegree = new int[N+1];
        for (int i=0; i<=N; i++){
            A.add(new ArrayList<>());
        }
        for (int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            A.get(S).add(E);
            indegree[E]++;
        }
        topology();
        System.out.println(sb);
    }
    static void topology(){
        Queue<Integer> queue = new LinkedList();
        for (int i=1; i<=N; i++){
            if (indegree[i] == 0) queue.offer(i);
        }
        while (!queue.isEmpty()){
            int now = queue.poll();
            sb.append(now).append(" ");
            for (int next : A.get(now)){
                indegree[next]--;
                if (indegree[next] == 0){
                    queue.offer(next);
                }
            }
        }
    }
}