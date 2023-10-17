import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static StringTokenizer st;
	static PriorityQueue<int[]> pQueue;
	static int[] index;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		//pQueue에는 value, index 순서로 들어간다
		pQueue = new PriorityQueue<>(
			(o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]
		);
		index = new int[N+1];
		st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		for (int i=1; i<=N; i++){
			int num = Integer.parseInt(st.nextToken());
			pQueue.offer(new int[]{num, i});
			index[i] = num;
		}
		M = Integer.parseInt(br.readLine());
		while (M-- > 0){
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			if (command == 1){
				int oldIdx = Integer.parseInt(st.nextToken());
				int newVal = Integer.parseInt(st.nextToken());
				pQueue.offer(new int[]{newVal, oldIdx});
				index[oldIdx] = newVal;
			} else {
				while (true){
					int[] tmp = pQueue.peek();
					int tmpVal = tmp[0];
					int tmpIdx = tmp[1];
					if (index[tmpIdx] == tmpVal){
						sb.append(tmpIdx).append("\n");
						break;
					} else {
						pQueue.poll();
					}
				}
			}
		}
		System.out.println(sb.toString());
	}
}
