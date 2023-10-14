import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N;

	static class schedule{
		int start;
		int end;

		public schedule(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	static PriorityQueue<Integer> pQueue = new PriorityQueue<>();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ArrayList<schedule> schedules = new ArrayList<>();
		while (N-- > 0){
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			schedules.add(new schedule(start, end));
		}
		schedules.sort((o1, o2) -> o1.start == o2.start ? o1.end - o2.end : o1.start - o2.start);
		pQueue.offer(schedules.get(0).end);
		for (int i=1; i<schedules.size(); i++){
			if (pQueue.peek() <= schedules.get(i).start){
				pQueue.poll();
			}
			pQueue.offer(schedules.get(i).end);
		}
		System.out.println(pQueue.size());
	}
}
