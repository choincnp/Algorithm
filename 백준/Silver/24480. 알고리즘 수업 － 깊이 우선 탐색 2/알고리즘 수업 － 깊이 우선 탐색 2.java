import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
	/*
	 * 정점 N, 간선 M, 무방향, 가중치 같다. 내림차순 방문한다
	 * DFS 이용
	 */

	static int N, M, R, u, v, count = 1;
	static ArrayList<Integer>[] arr;

	static int[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new ArrayList[N+1];
		visited = new int[N+1];
		IntStream.range(1, N+1).forEach(i -> arr[i] = new ArrayList<>());
		while(M-- > 0){
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			arr[u].add(v);
			arr[v].add(u);
		}
		DFS(R);
		IntStream.range(1, N+1).forEach(i -> sb.append(visited[i] + "\n"));
		System.out.println(sb);
	}
	static void DFS(int start){
		visited[start] = count++;
		Collections.sort(arr[start], Collections.reverseOrder());
		for (Integer next : arr[start]) {
			if (visited[next] == 0){
				DFS(next);
			}
		}
	}
}