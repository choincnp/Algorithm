import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{

    static int N, M;
    static int[] distance;
    static boolean[] visited;
    static ArrayList<Node>[] list;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        visited = new boolean[N+1];
        distance = new int[N+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        for (int i=0; i<=N; i++){
            list[i] = new ArrayList<>();
        }
        M = Integer.parseInt(br.readLine());
        while (M-- > 0){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            list[S].add(new Node(E, W));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int dest = Integer.parseInt(st.nextToken());
        System.out.println(djikstra(start, dest));

    }
    static int djikstra(int start, int dest){
        PriorityQueue<Node> pQueue = new PriorityQueue<>(
                Comparator.comparingInt(o -> o.cost)
        );
        pQueue.offer(new Node(start, 0));
        distance[start] = 0;
        while (!pQueue.isEmpty()){
            Node node = pQueue.poll();
            int now = node.dest;
            if (!visited[now]){
                visited[now] = true;
                for (Node next : list[now]){
                    if (!visited[next.dest] && distance[next.dest] > distance[now] + next.cost){
                        distance[next.dest] = distance[now] + next.cost;
                        pQueue.offer(new Node(next.dest, distance[next.dest]));
                    }
                }
            }
        }
        return distance[dest];
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