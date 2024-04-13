import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		PriorityQueue<Integer> pQueue = new PriorityQueue<>();
		st = new StringTokenizer(br.readLine());
		while (N --> 0){
			pQueue.offer(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine());
		while (M --> 0){
			pQueue.offer(Integer.parseInt(st.nextToken()));
		}
		while (!pQueue.isEmpty()){
			sb.append(pQueue.poll() + " ");
		}
		System.out.println(sb);
	}
}