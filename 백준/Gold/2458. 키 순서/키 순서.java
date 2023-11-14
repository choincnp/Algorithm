import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
    static StringTokenizer st;
    static int N, M, taller[], shorter[];
    static ArrayList<Integer>[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N+1];
        shorter = new int[N+1];
        taller = new int[N+1];
        for (int i=1; i<=N; i++){
            arr[i] = new ArrayList<>();
        }
        while (M-- > 0){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            arr[S].add(E);
        }
        for (int i=1; i<=N; i++){
            DFS(i, i, new boolean[N+1]);
        }
        int answer = 0;
        for (int i=1; i<=N; i++){
            if (taller[i] + shorter[i] == N-1) answer++;
        }

        System.out.println(answer);
    }
    static void DFS(int start, int now, boolean[] visited){
        visited[now] = true;
        for (int i : arr[now]){
            if (!visited[i]){
                visited[i] = true;
                taller[start]++;
                shorter[i]++;
                DFS(start, i, visited);
            }
        }
    }
}