import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

	static boolean[] answer;
	static boolean[][] visited;
	static int[] bucket;
	static int[] start = {0,0,1,1,2,2};
	static int[] dest = {1,2,0,2,0,1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		bucket = new int[3];
		bucket[0] = Integer.parseInt(st.nextToken());
		bucket[1] = Integer.parseInt(st.nextToken());
		bucket[2] = Integer.parseInt(st.nextToken());
		visited = new boolean[201][201];
		answer = new boolean[201];
		BFS();
		for (int i=0; i<201; i++){
			if (answer[i]) sb.append(i).append(" ");
		}
		System.out.println(sb.toString());
	}
	static void BFS(){
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{0, 0});
		visited[0][0] = true;
		answer[bucket[2]] = true;
		while (!queue.isEmpty()){
			int[] now = queue.poll();
			int A = now[0];
			int B = now[1];
			int C = bucket[2] - A - B;
			for (int i=0; i<6; i++){
				int[] next = {A, B, C};
				next[dest[i]] += next[start[i]];
				next[start[i]] = 0;
				if (next[dest[i]] > bucket[dest[i]]){
					next[start[i]] = next[dest[i]] - bucket[dest[i]];
					next[dest[i]] = bucket[dest[i]];
				}
				if (!visited[next[0]][next[1]]){
					queue.offer(new int[]{next[0], next[1]});
					visited[next[0]][next[1]] = true;
					if (next[0] == 0){
						answer[next[2]] = true;
					}
				}
			}
		}
	}
}