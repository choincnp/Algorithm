import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	/*
	 * N개의 정점과 M개의 간선으로 구성된 무방향 그래프(undirected graph)가 주어진다
	 * 정점 R에서 시작하여 너비 우선 탐색으로 노드를 방문할 경우 노드의 방문 순서를 출력
	 * 인접 정점은 오름차순으로 방문
	 * bfs(V, E, R) {  # V : 정점 집합, E : 간선 집합, R : 시작 정점
 	 * 	for each v ∈ V - {R}
     *	   visited[v] <- NO;
     *	visited[R] <- YES;  # 시작 정점 R을 방문 했다고 표시한다.
     *	enqueue(Q, R);  # 큐 맨 뒤에 시작 정점 R을 추가한다.
     *	while (Q ≠ ∅) {
     *   u <- dequeue(Q);  # 큐 맨 앞쪽의 요소를 삭제한다.
     *   for each v ∈ E(u)  # E(u) : 정점 u의 인접 정점 집합.(정점 번호를 오름차순으로 방문한다)
     *       if (visited[v] = NO) then {
     *           visited[v] <- YES;  # 정점 v를 방문 했다고 표시한다.
     *           enqueue(Q, v);  # 큐 맨 뒤에 정점 v를 추가한다.
     *       }
     *	 }
	 *	}
	 * ArrayList<>[]를 만들어서 정점, 간선 연결
	 * Queue를 이용한 탐색
	 * visited배열 만든다
	 */
	static StringBuilder sb = new StringBuilder();

	static Queue<Integer> queue = new LinkedList<>();
	static boolean[] visited;
	static ArrayList<Integer>[] arr;
	static int[] result;
	static int count = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		arr = new ArrayList[N+1];
		visited = new boolean[N+1];
		result = new int[N+1];
		for (int i=1; i<N+1; i++){
			arr[i] = new ArrayList<>();
		}
		while (M -- > 0){
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			arr[u].add(v);
			arr[v].add(u);
		}
		BFS(R);
		for (int i=1; i< result.length; i++){
			sb.append(result[i]).append("\n");
		}
		System.out.println(sb);
	}
	static void BFS(int start){
		Collections.sort(arr[start]);
		visited[start] = true;
		result[start] = count;
		count++;
		queue.offer(start);
		while (!queue.isEmpty()){
			int now = queue.poll();
            Collections.sort(arr[now]);
			for (Integer next : arr[now]) {
				if(!visited[next]){
					visited[next] = true;
					result[next] = count++;
					queue.offer(next);
				}
			}
		}
	}
}