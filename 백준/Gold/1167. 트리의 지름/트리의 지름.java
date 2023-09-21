import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static ArrayList<Edge>[] arr;
	static boolean[] visited;
	static int[] distance;
	static StringTokenizer st;
	static class Edge{
		int e;
		int val;

		public Edge(int e, int val) {
			this.e = e;
			this.val = val;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new ArrayList[N+1];
		visited = new boolean[N+1];
		distance = new int[N+1];
		for (int i=1; i<N+1; i++){
			arr[i] = new ArrayList<>();
		}
		for (int i=1; i<=N; i++){
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			while (true){
				int E = Integer.parseInt(st.nextToken());
				if (E == -1){
					break;
				}
				int V = Integer.parseInt(st.nextToken());
				arr[S].add(new Edge(E, V));
			}
		}
		BFS(1);
		int max = 1;
		for (int i=2; i<N+1; i++){
			if (distance[max] < distance[i]){
				max = i;
			}
		}
		distance = new int[N+1];
		visited = new boolean[N+1];
		BFS(max);
		Arrays.sort(distance);
		System.out.println(distance[N]);

	}

	static void BFS(int x){
		Queue<Integer> queue = new LinkedList<>();
		queue.add(x);
		visited[x] = true;
		while (!queue.isEmpty()){
			int point = queue.poll();
			for (Edge E : arr[point]){
				int e = E.e;
				int v = E.val;
				if (!visited[e]){
					visited[e] = true;
					queue.add(e);
					distance[e] = distance[point] + v;
				}
			}
		}
	}
}
