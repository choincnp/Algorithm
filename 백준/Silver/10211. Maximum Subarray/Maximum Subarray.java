import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while (T-->0){
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());
			PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());
			for (int i=0; i<N; i++){
				arr[i] = Integer.parseInt(st.nextToken());
			}
			for (int i=0; i<N; i++){
				int sum = 0;
				for (int j=i; j<N; j++){
					sum += arr[j];
					pQueue.offer(sum);
				}
			}
			sb.append(pQueue.poll()).append("\n");
		}
		System.out.println(sb.toString());
	}
}