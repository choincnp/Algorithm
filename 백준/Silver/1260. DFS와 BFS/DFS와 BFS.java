import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, V;

    static ArrayList<Integer>[] arr;

    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N+1];
        visited = new boolean[N+1];
        for (int i=1; i<=N; i++){
           arr[i] = new ArrayList<>();
        }
        for (int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s].add(e);
            arr[e].add(s);
        }
        for (int i=1; i<=N; i++){
            Collections.sort(arr[i]);
        }
        DFS(V);
        sb.append("\n");
        visited = new boolean[N+1];
        BFS(V);
        System.out.println(sb.toString());
    }
    static void DFS(int x){
        sb.append(x).append(" ");
        visited[x] = true;
        for (int i : arr[x]){
            if (!visited[i]){
                DFS(i);
            }
        }
    }

    static void BFS(int x){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        visited[x] = true;

        while (!queue.isEmpty()){
            int i = queue.poll();
            sb.append(i).append(" ");
            for (int n : arr[i]){
                if (!visited[n]){
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
}
