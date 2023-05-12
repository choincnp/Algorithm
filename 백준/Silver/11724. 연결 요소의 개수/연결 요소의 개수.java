import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] A;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		A = new ArrayList[N+1]; // 인접 리스트 1부터할거라 배열크기 N+1로 줌
		visited = new boolean[N+1]; // 방문 배열

		for (int i=1; i<N+1; i++) { // 인접 리스트 초기화하기
			A[i] = new ArrayList<Integer>();
		}
		for (int i=0; i<M; i++){
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			A[s].add(e); // 양방 에지이므로 양쪽에 에지 더하기
			A[e].add(s);
		}
		int count = 0;
		for (int i=1; i<N+1; i++) {
			if (!visited[i]) {
				dfs(i);
				count++;
			}
		}
		System.out.println(count);
	}
	static void dfs(int v){
		if (visited[v]) return;
		visited[v] = true;
		for (int i : A[v]){
			if (visited[i] == false){
				dfs(i);
			}
		}
	}
}