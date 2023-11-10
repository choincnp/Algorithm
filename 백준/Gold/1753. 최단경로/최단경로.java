import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
    static int N, E, start;
    static boolean[] visited;
    static int[] distance;
    static ArrayList<Edge>[] arr;
    static PriorityQueue<Edge> pQueue;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        distance = new int[N+1];
        arr = new ArrayList[N+1];
        for (int i=1; i<=N; i++){
            arr[i] = new ArrayList<>();
        }
        for (int i=0; i<=N; i++){
            distance[i] = Integer.MAX_VALUE;
        }
        while (E-- > 0){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            arr[S].add(new Edge(E, val));
        }
        dijkstra(start);
        for (int i=1; i<=N; i++){
            if (visited[i]){
                System.out.println(distance[i]);
            } else {
                System.out.println("INF");
            }
        }
    }
    static void dijkstra(int n){
        pQueue = new PriorityQueue<>();
        pQueue.offer(new Edge(n, 0));
        distance[n] = 0;
//        visited[n] = true;
        while (!pQueue.isEmpty()){
            Edge now = pQueue.poll();
            if (!visited[now.num]){
                visited[now.num] = true;
                for (int i=0; i<arr[now.num].size(); i++){
                    Edge next = arr[now.num].get(i);
                    if (distance[next.num] > distance[now.num] + next.val){
                        distance[next.num] = distance[now.num] + next.val;
                        pQueue.offer(new Edge(next.num, distance[next.num]));
                    }

                }
            }
        }
    }
    static class Edge implements Comparable<Edge>{
        int num;
        int val;

        public Edge(int num, int val) {
            this.num = num;
            this.val = val;
        }

        @Override
        public int compareTo(Edge o) {
            if (this.val > o.val) return 1;
            else return -1;
        }
    }
}