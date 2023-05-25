import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	static int count = 0;
	static Deque<Integer> deque = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		for (int i=0; i<N; i++){
			deque.add(i+1);
		}
		st = new StringTokenizer(br.readLine());
		while (M-- > 0){
			int target = Integer.parseInt(st.nextToken());
			int index = 0;
			for (int i : deque){
				if (i == target){
					break;
				}
				index++;
			}
			while (true){
				if (deque.peek() == target){
					deque.poll();
					break;
				}
				if (index <= deque.size()/2){
					poll(deque);
				} else {
					addFirst(deque);
				}
			}
		}
		System.out.println(count);
	}
	public static void poll(Deque<Integer> deque){
		deque.offer(deque.poll());
		count++;
	}
	public static void addFirst(Deque<Integer> deque){
		deque.addFirst(deque.pollLast());
		count++;
	}
}