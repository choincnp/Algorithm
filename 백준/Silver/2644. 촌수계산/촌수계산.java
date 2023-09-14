import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static ArrayList<Integer>[] relationship;

    static boolean[] visited;

    static int T, A, B, C, count, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 전체 사람 수
        T = Integer.parseInt(br.readLine());
        // 사람 2명
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        // 전체 케이스 수
        C = Integer.parseInt(br.readLine());
        relationship = new ArrayList[T+1];
        visited = new boolean[T+1];
        for (int i=0; i<T+1; i++){
            relationship[i] = new ArrayList<>();
        }
        for (int i=0; i<C; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            relationship[s].add(e);
            relationship[e].add(s);
        }
        count = 0;
        answer = -1;
        DFS(A, count);
        System.out.println(answer);

    }
    static void DFS(int x, int count) {
        if (x == B){
            answer = count;
        }
        visited[x] = true;
        for (int i : relationship[x]){
            if (!visited[i]){
                DFS(i, count+1);
            }
        }
    }
}