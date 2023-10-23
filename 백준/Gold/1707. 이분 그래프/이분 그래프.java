import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int K, V, E;
	static StringTokenizer st;
	static ArrayList<Integer>[] graphs;
	static int[] colored;
	static final int RED = 1, BLUE = -1;
	static int color;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		while (K-- > 0){
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			graphs = new ArrayList[V+1];
			colored = new int[V+1];
			for (int i=0; i<V+1; i++){
				graphs[i] = new ArrayList<>();
			}
			while (E-- > 0){
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				graphs[start].add(end);
				graphs[end].add(start);
			}
			//방문하지 않았고 칠해져있지 않다면 DFS돌림
			color = RED;
			boolean checked = true;
			for (int i=1; i<V+1; i++){
				if (colored[i] == 0){
					DFS(i, color);
				}
			}

			for (int i=1; i<V+1; i++){
				for (int j : graphs[i]){
					if (colored[i] == colored[j]) checked = false;
				}
			}
			if (checked){
				sb.append("YES\n");
			} else {
				sb.append("NO\n");
			}
		}
		System.out.println(sb.toString());
	}
	static void DFS(int i, int color){
		colored[i] = color;
		for (int x : graphs[i]){
			if (colored[x] == 0){
				DFS(x, -color);
			}
		}
	}
}
