import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	/*
	 * N개의 정점과 M개의 간선 "무방향" 그래프, 가중치 같음 -> DFS
	 * 인접 정점은 오름차순으로 출력
	 * 알고리즘 다음과 같음
	 * dfs(V, E, R) {  # V : 정점 집합, E : 간선 집합, R : 시작 정점
     * visited[R] <- YES;  # 시작 정점 R을 방문 했다고 표시한다.
     * for each x ∈ E(R)  # E(R) : 정점 R의 인접 정점 집합.(정점 번호를 오름차순으로 방문한다)
     * if (visited[x] = NO) then dfs(V, E, x);
	 * }
	 * 먼저, ArrayList<Integer>[N+1], boolean[N+1] 생성
	 * arr[u]에 v 연결
	 * R 부터 방문
	 * 방문 못하면 0 출력
	 */
	static StringBuilder sb = new StringBuilder();
	static boolean[] visited;
	static int[] result;
	static int count = 1;
	static ArrayList<Integer>[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		arr = new ArrayList[N+1];
		//초기화
		for (int i=1; i<N+1; i++){
			arr[i] = new ArrayList<>();
		}
		visited = new boolean[N+1];
		result = new int[N+1];
		while (M -- > 0){
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			arr[u].add(v);
			arr[v].add(u);
		}
		dfs(R);
		for (int i=1; i<N+1; i++){
			sb.append(result[i]).append("\n");
		}
		System.out.println(sb);
	}
	static void dfs(int start){
		visited[start] = true;
		result[start] = count;
		count++;
		Collections.sort(arr[start]);
		for (Integer i : arr[start]) {
			if (!visited[i]){
				dfs(i);
			}
		}
	}
}