import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int N;
	static int[] route;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		route = new int[N+1];
		BFS(N);
		System.out.println(sb.toString());
	}
	static void BFS(int n){
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(n);
		while (!queue.isEmpty()){
			int now = queue.poll();
			if (now == 1){
				//1로 왔을 경우
				ArrayList<Integer> answer = new ArrayList<>();
				answer.add(n);
				while (now != N){
					answer.add(now);
					now = route[now];
				}
				Collections.sort(answer, Collections.reverseOrder());
				sb.append(answer.size()-1).append("\n");
				for (int i=0; i<answer.size(); i++){
					sb.append(answer.get(i)).append(" ");
				}
			} else {
				if (route[now-1] == 0){
					route[now-1] = now;
					queue.offer(now-1);
				}
				if (now%3 == 0 && route[now/3] == 0){
					route[now/3] = now;
					queue.offer(now/3);
				}
				if (now%2 == 0 && route[now/2] == 0){
					route[now/2] = now;
					queue.offer(now/2);
				}
			}
		}
	}
}
