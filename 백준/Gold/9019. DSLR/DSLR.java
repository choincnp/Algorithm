import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, start, dest;
	static boolean[] visited;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static Queue<number> queue;
	static class number{
		int num;
		String command;

		public number(int num, String command) {
			this.num = num;
			this.command = command;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		while (N-- > 0){
			queue = new LinkedList<>();
			visited = new boolean[10000];
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			dest = Integer.parseInt(st.nextToken());
			queue.offer(new number(start, ""));
			BFS();
		}
		System.out.println(sb.toString());
	}
	static void BFS(){
		while (!queue.isEmpty()) {
			number point = queue.poll();
			int num = point.num;
			String command = point.command;
			if (num == dest) {
				sb.append(command).append("\n");
				return;
			}
			visited[num] = true;
			int d = D(num);
			int s = S(num);
			int l = L(num);
			int r = R(num);
			if (!visited[d]){
				queue.offer(new number(d, command+"D"));
				visited[d] = true;
			}
			if (!visited[s]){
				queue.offer(new number(s, command+"S"));
				visited[s] = true;
			}
			if (!visited[l]){
				queue.offer(new number(l, command+"L"));
				visited[l] = true;
			}
			if (!visited[r]){
				queue.offer(new number(r, command+"R"));
				visited[r] = true;
			}
		}
	}

	static int D(int x){
		if (x >= 5000){
			return 2 * x % 10000;
		} else{
			return 2 * x;
		}
	}

	static int S(int x){
		if (x == 0) return 9999;
		else return x-1;
	}

	static int L(int x){
		return (x%1000) * 10 + x / 1000;
	}

	static int R(int x){
		return (x%10) * 1000 + x / 10;
	}

}
