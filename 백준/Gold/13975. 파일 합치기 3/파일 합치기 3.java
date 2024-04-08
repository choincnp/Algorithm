import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	/*
	 * pQueue 이용
	 */
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		while (N-- > 0){
			int T = Integer.parseInt(br.readLine());
			PriorityQueue<Long> pQueue = new PriorityQueue<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			while (T-->0){
				pQueue.offer(Long.parseLong(st.nextToken()));
			}
			long sum = 0;
			while (!(pQueue.size() == 1)){
				Long n1 = pQueue.poll();
				Long n2 = pQueue.poll();
				sum += (n1 + n2);
				pQueue.offer(n1+n2);
			}
			System.out.println(sum);
		}
	}
}