import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static boolean visited[];
	static ArrayList<Integer>[] A;
	static boolean arrive;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		A = new ArrayList[N];
		visited = new boolean[N];
		for (int i=0; i<N; i++){
			A[i] = new ArrayList<Integer>();
		}
		for (int i=0; i<M; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			A[a].add(b);
			A[b].add(a);
		}
		for (int i=0; i<N; i++){
			dfs(i, 1);
			if (arrive) break;
		}
		System.out.println(arrive ? 1 : 0);
	}

	public static void dfs(int now, int depth) {
		if (depth == 5){
			arrive = true;
			return;
		}
		visited[now] = true;
		for (int i : A[now]){
			if (!visited[i]){
				dfs(i, depth+1);
			}
		}
		visited[now] = false;
	}
}