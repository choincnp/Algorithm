import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;
	static boolean[] notPrime;
	static boolean[] visited;
	static boolean able;
	static int N, count;
	static String A, B;
	static class Node{
		String num;
		int count;
		public Node(String num, int count) {
			this.num = num;
			this.count = count;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		notPrime = new boolean[10000];
		for (int i=2; i<=100; i++){
			for (int j=i+i; j<10000; j+=i){
				notPrime[j] = true;
			}
		}
		while (N-- > 0){
			st = new StringTokenizer(br.readLine());
			A = st.nextToken();
			B = st.nextToken();
			able = false;
			count = 0;
			BFS(A, B);
			if (!able){
				sb.append("Impossible\n");
			} else {
				sb.append(count).append("\n");
			}
		}
		System.out.println(sb.toString());
		br.close();
	}
	static void BFS(String A, String B){
		visited = new boolean[10000];
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(A, 0));
		visited[Integer.parseInt(A)] = true;
		while (!queue.isEmpty()){
			Node now = queue.poll();
			if (now.num.equals(B)){
				able = true;
				count = now.count;
				return;
			}
			for (int i=0; i<10; i++){
				for (int j=0; j<4; j++){
					String next = convert(now.num, j, i);
					int converted = Integer.parseInt(next);
					if (!visited[converted] && converted >= 1000 && !notPrime[converted]){
						queue.offer(new Node(next, now.count+1));
						visited[converted] = true;
					}
				}
			}
		}
	}
	static String convert(String s, int digit, int dest){
		char[] tmp = s.toCharArray();
		tmp[digit] = (char)('0'+dest);
		return String.valueOf(tmp);
	}
}
