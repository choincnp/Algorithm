import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int diameter;
	static int max;
	static ArrayList<Node>[] arr;
	static boolean[] visited;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new ArrayList[N+1];
		visited = new boolean[N+1];
		for (int i=0; i<N+1; i++){
			arr[i] = new ArrayList<>();
		}
		for (int i=0; i<N-1; i++){
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());
			arr[S].add(new Node(E, val));
			arr[E].add(new Node(S, val));
		}
		DFS(1, 0);
		visited = new boolean[N+1];
		DFS(max, 0);
		System.out.println(diameter);

	}
	static void DFS(int x, int len){
		if (len > diameter){
			diameter = len;
			max = x;
		}
		visited[x] = true;
		for (Node n : arr[x]){
			if (!visited[n.num]){
				DFS(n.num, len+n.val);
				visited[n.num] = true;
			}
		}
	}
	static class Node{
		int num;
		int val;
		public Node(int num, int val){
			this.num = num;
			this.val = val;
		}
		
	}
}