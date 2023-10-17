import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static PriorityQueue<Integer> minQueue;
	static PriorityQueue<Integer> maxQueue;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		while (N -- > 0){
			M = Integer.parseInt(br.readLine());
			sb.append((M+1)/2).append("\n");
			minQueue = new PriorityQueue<>();
			maxQueue = new PriorityQueue<>(Collections.reverseOrder());
			for (int i=0; i<M; i++){
				if (i%10 == 0) st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken());
				if (minQueue.size() == maxQueue.size()){
					maxQueue.offer(num);
				} else{
					minQueue.offer(num);
				}
				if (!minQueue.isEmpty()){
					if (maxQueue.peek() > minQueue.peek()){
						int max = maxQueue.poll();
						int min = minQueue.poll();
						minQueue.offer(max);
						maxQueue.offer(min);
					}
				}
				if (i%2 == 0){
					if ((i!=0) && i%18 == 0 || i==M-1){
						sb.append(maxQueue.peek()).append("\n");
					} else {
						sb.append(maxQueue.peek()).append(" ");
					}
				}
			}
		}
		System.out.println(sb.toString());
	}
}
