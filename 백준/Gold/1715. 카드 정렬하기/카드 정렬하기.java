import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pQueue = new PriorityQueue<>();
		for (int i=0; i<N; i++){
			pQueue.add(Integer.parseInt(br.readLine()));
		}
		int sum = 0;
		while (pQueue.size() > 1){
			int num = pQueue.poll();
			int num2 = pQueue.poll();
			sum += num + num2;
			pQueue.add(num + num2);
		}
		System.out.println(sum);
	}
}