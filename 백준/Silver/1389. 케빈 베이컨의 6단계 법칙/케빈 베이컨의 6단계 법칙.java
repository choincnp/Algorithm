import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static StringTokenizer st;
	static ArrayList<Integer>[] relationship;
	static Queue<bacon> queue;
	static boolean[] visited;
	static class bacon{
		int start;
		int count;

		public bacon(int start, int count) {
			this.start = start;
			this.count = count;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		relationship = new ArrayList[N+1];
		for (int i=1; i<=N; i++){
			relationship[i] = new ArrayList<>();
		}
		M = Integer.parseInt(st.nextToken());
		while (M-- > 0){
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int dest = Integer.parseInt(st.nextToken());
			relationship[start].add(dest);
			relationship[dest].add(start);
		}
		int answer = 0;
		int min = Integer.MAX_VALUE;
		for (int i=1; i<=N; i++){
			int bacon = BFS(i);
			if (bacon < min){
				min = bacon;
				answer = i;
			}
		}
		System.out.println(answer);
	}
	static int BFS(int x){
		queue = new LinkedList<>();
		visited = new boolean[N+1];
		queue.offer(new bacon(x, 0));
		visited[x] = true;
		int count = 0;
		while (!queue.isEmpty()){
			bacon now = queue.poll();
			for (int dest : relationship[now.start]){
				if (!visited[dest]){
					count += now.count + 1;
					visited[dest] = true;
					queue.offer(new bacon(dest, now.count + 1));
				}
			}
		}
		return count;
	}
}
