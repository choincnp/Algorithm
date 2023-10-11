import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static class jewelry{
		int weight;
		int value;

		public jewelry(int weight, int value) {
			this.weight = weight;
			this.value = value;
		}
	}
	static int[] bag;
	static ArrayList<jewelry> jewelries = new ArrayList<>();

	static PriorityQueue<jewelry> pQueue = new PriorityQueue<>(
		(o1, o2) -> o2.value - o1.value
	);

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		for (int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			jewelries.add(new jewelry(weight, value));
		}
		Collections.sort(jewelries, Comparator.comparingInt(o -> o.weight));
		bag = new int[K];
		for (int i=0; i<K; i++){
			bag[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(bag);
		long sum = 0;
		int index = 0;
		for (int i=0; i<K; i++){
			while (index < N && jewelries.get(index).weight <= bag[i]){
				pQueue.offer(jewelries.get(index++));
			}
			if(!pQueue.isEmpty()){
				sum += pQueue.poll().value;
			}
		}
		System.out.println(sum);
	}
}
