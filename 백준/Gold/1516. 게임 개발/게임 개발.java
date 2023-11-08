import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static int N;
    static StringTokenizer st;
    static int[] indegree, time, result;
    static ArrayList<ArrayList<Integer>> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new ArrayList<>();
        indegree = new int[N+1];
        time = new int[N+1];
        result = new int[N+1];
        for (int i=0; i<=N; i++){
            arr.add(new ArrayList<>());
        }
        for (int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            while (true){
                int B = Integer.parseInt(st.nextToken());
                if (B == -1){
                    break;
                }
                arr.get(B).add(i);
                indegree[i]++;
            }
        }
        topology();
        for (int i=1; i<=N; i++){
            System.out.println(result[i] + time[i]);
        }
    }
    static void topology(){
        Queue<Integer> queue = new LinkedList<>();
        for (int i=1; i<=N; i++){
            if (indegree[i] == 0){
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()){
            int now = queue.poll();
            for (int next : arr.get(now)){
                indegree[next]--;
                result[next] = Math.max(result[next], result[now] + time[now]);
                if (indegree[next] == 0){
                    queue.offer(next);
                }
            }
        }
    }
}