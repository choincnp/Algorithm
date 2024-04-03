import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		PriorityQueue<Long> pQueue = new PriorityQueue<>();
		long N = Long.parseLong(st.nextToken());
		long T = Long.parseLong(st.nextToken());
		st = new StringTokenizer(br.readLine());
		while (N-- > 0){
			pQueue.offer(Long.parseLong(st.nextToken()));
		}
		while (T -- > 0){
			long start = pQueue.poll();
			long next = pQueue.poll();
			start += next;
			pQueue.offer(start);
			pQueue.offer(start);
		}
		System.out.println(pQueue.stream().reduce(0L, Long::sum));
	}
}