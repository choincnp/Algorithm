import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static ArrayList<Integer>[] computer;
	static boolean[] visited;
	static ArrayList<Integer> answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		computer = new ArrayList[N+1];
		for (int i=0 ; i < N+1; i++){
			computer[i] = new ArrayList<>();
		}
		while (M-->0){
			st = new StringTokenizer(br.readLine());
			int trust = Integer.parseInt(st.nextToken());
			int trusted = Integer.parseInt(st.nextToken());
			computer[trusted].add(trust);
		}
		int max = Integer.MIN_VALUE;
        answer = new ArrayList<>();
		for (int i=1; i<N+1; i++){
			int count = BFS(i);
			if (count > max){
				max = count;
				answer.clear();
				answer.add(i);
			} else if (count == max){
				answer.add(i);
			}
		}
		Collections.sort(answer);
		for (int i=0; i<answer.size(); i++){
			if (i == answer.size()-1){
				sb.append(answer.get(i));
			} else{
				sb.append(answer.get(i)).append(" ");
			}
		}
		System.out.println(sb.toString());
	}
	static int BFS(int start){
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited = new boolean[N+1];
		visited[start] = true;
		int count = 0;
		while (!queue.isEmpty()){
			int now = queue.poll();
			for (int com : computer[now]){
				if (!visited[com]){
					queue.offer(com);
					count++;
					visited[com] = true;
				}
			}
		}
		return count;
	}
}
