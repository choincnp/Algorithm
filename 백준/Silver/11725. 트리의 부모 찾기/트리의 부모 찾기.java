import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        arr = new ArrayList[T+1];
        parent = new int[T+1];
        visited = new boolean[T+1];
        for (int i = 1; i<T+1; i++){
            arr[i] = new ArrayList<>();
        }
        for (int i=0; i<T-1; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s].add(e);
            arr[e].add(s);
        }
        //DFS
        DFS(1);

        // 출력
        for (int i=2; i<T+1; i++){
            System.out.println(parent[i]);
        }
    }
    static void DFS(int x){
        visited[x] = true;
        for (int i : arr[x]){
            if (!visited[i]){
                parent[i] = x;
                DFS(i);
            }
        }
    }
}
