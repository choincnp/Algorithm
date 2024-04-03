import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());
		for (int i=0; i<N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++){
				pQueue.offer(Integer.parseInt(st.nextToken()));
			}
		}
		while (N-- > 1){
			pQueue.poll();
		}
		System.out.println(pQueue.poll());
	}
}