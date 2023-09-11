import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer>[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        arr = new ArrayList[T+1];
        visited = new boolean[T+1];
        //인접 리스트 초기화하기
        for (int i=1; i<T+1; i++){
            arr[i] = new ArrayList<Integer>();
        }
        //배열 채워넣기
        for (int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s].add(e);
            arr[e].add(s);
        }
        // 결괏값 설정
        int result = 0;
        // DFS 시작
        DFS(1);

        // 방문한 컴퓨터 보기
        for (boolean i : visited){
            if (i) result++;
        }
        System.out.println(result-1);
    }
    static void DFS(int v){
        // 방문했으면 더이상 볼 필요 없다
        if (visited[v]) return;
        // 아닐경우 방문을 true값으로 보냄
        visited[v] = true;
        // 나머지 노드 방문
        for (int i : arr[v]){
            if (!visited[i]) DFS(i);
        }
    }
}
