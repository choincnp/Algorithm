import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{

    static int N, M, K;
    static ArrayList<Node>[] list, reverse_list;
    static boolean[] visited;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        reverse_list = new ArrayList[N+1];
        for (int i=0; i<=N; i++){
            list[i] = new ArrayList<>();
            reverse_list[i] = new ArrayList<>();
        }
        while (M-- > 0){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            list[S].add(new Node(E, W));
            reverse_list[E].add(new Node(S, W));
        }
        int[] dist = dijkstra(list);
        int[] reverse_dist = dijkstra(reverse_list);
        int max = 0;
        for (int i=1; i<=N; i++){
            max = Math.max(max, dist[i] + reverse_dist[i]);
        }
        System.out.println(max);

    }
    static int[] dijkstra(ArrayList<Node>[] list){
        PriorityQueue<Node> pQueue = new PriorityQueue<>(
                Comparator.comparingInt(o -> o.cost)
        );
        distance = new int[N+1];
        visited = new boolean[N+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        pQueue.offer(new Node(K, 0));
        distance[K] = 0;
        while (!pQueue.isEmpty()){
            Node node = pQueue.poll();
            int now = node.dest;
            if (!visited[now]){
                visited[now] = true;
                for (Node next : list[now]) {
                    if (!visited[next.dest] && distance[next.dest] > distance[now] + next.cost){
                        distance[next.dest] = distance[now] + next.cost;
                        pQueue.offer(new Node(next.dest, distance[next.dest]));
                    }
                }
            }
        }
        return distance;
    }
    static class Node{
        int dest;
        int cost;

        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }
}