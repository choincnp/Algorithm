import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		Queue<Integer>[] queues = new Queue[21];
		for (int i=0; i<21; i++){
			queues[i] = new LinkedList<>();
		}
		long count = 0;
		for (int i=0; i<N; i++){
			int length = br.readLine().length();
			if (queues[length].isEmpty()){
				queues[length].offer(i);
			} else {
				while (i - queues[length].peek() > K){
					queues[length].poll();
					if (queues[length].isEmpty()){
						break;
					}
				}
				count += queues[length].size();
				queues[length].offer(i);
			}
		}
		System.out.println(count);
	}
}
