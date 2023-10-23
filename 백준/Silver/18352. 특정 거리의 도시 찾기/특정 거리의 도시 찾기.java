import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K, X;
	static ArrayList<Integer>[] road;
	static ArrayList<Integer> answer;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken()); // 거리
		X = Integer.parseInt(st.nextToken()); // 출발도시
		road = new ArrayList[N+1];
		visited = new boolean[N+1];
		answer = new ArrayList<>();
		for (int i=0; i<N+1; i++){
			road[i] = new ArrayList<>();
		}
		while (M-- > 0){
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			road[start].add(end);
		}
		BFS(X, K);
		Collections.sort(answer);
		if (answer.size() == 0){
			sb.append(-1);
		} else {
			for (int i : answer){
				sb.append(i).append("\n");
			}
		}
		System.out.println(sb.toString());
	}
	static void BFS(int start, int dist){
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{start, 0});
		visited[start] = true;
		while (!queue.isEmpty()){
			int[] now = queue.poll();
			if (now[1] == dist){
				answer.add(now[0]);
			}
			for (int city : road[now[0]]){
				if (!visited[city]){
					queue.offer(new int[]{city, now[1]+1});
					visited[city] = true;
				}
			}
		}
	}
}
