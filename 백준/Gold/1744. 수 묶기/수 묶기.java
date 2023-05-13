import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> posQueue = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> negQueue = new PriorityQueue<>();
		int oneCount = 0;
		int zeroCount = 0;
		int sum = 0;
		for (int i=0; i<N; i++){
			int num = Integer.parseInt(br.readLine());
			if (num == 0) zeroCount++;
			else if (num == 1) oneCount++;
			else if (num > 1) posQueue.add(num);
			else negQueue.add(num);
		}
		while (posQueue.size() > 1){
			int num1 = posQueue.poll();
			int num2 = posQueue.poll();
			sum += num1 * num2;
		}
		if (posQueue.size() == 1) sum += posQueue.poll();

		while (negQueue.size()>1){
			int num1 = negQueue.poll();
			int num2 = negQueue.poll();
			sum += num1 * num2;
		}
		if (zeroCount > 0 && !negQueue.isEmpty() && negQueue.peek()<0){
			int tmp = 0 * negQueue.poll();
			sum += tmp;
		}
		if (negQueue.size() == 1) sum += negQueue.poll();
		sum += oneCount;
		System.out.println(sum);
	}
}