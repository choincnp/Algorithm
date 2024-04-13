import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	// 국어 점수가 내림차순
	// 영어 점수가 오름차순
	// 수학 점수가 내림차순
	// 이름 사전순
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		PriorityQueue<classMate> pQueue = new PriorityQueue<>(new Comparator<classMate>() {
			@Override
			public int compare(classMate o1, classMate o2) {
				if (o1.korScore != o2.korScore) return o2.korScore - o1.korScore;
				else if (o1.engScore != o2.engScore) return o1.engScore - o2.engScore;
				else if (o1.mathScore != o2.mathScore) return o2.mathScore - o1.mathScore;
				else return o1.name.compareTo(o2.name);
			}
		});
		while (T --> 0){
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int korScore = Integer.parseInt(st.nextToken());
			int engScore = Integer.parseInt(st.nextToken());
			int mathScore = Integer.parseInt(st.nextToken());
			pQueue.offer(new classMate(name, korScore, engScore, mathScore));
		}
		while (!pQueue.isEmpty()){
			System.out.println(pQueue.poll().name);
		}

	}
	static class classMate {
		String name;
		int korScore;
		int engScore;
		int mathScore;

		public classMate(String name, int korScore, int engScore, int mathScore) {
			this.name = name;
			this.korScore = korScore;
			this.engScore = engScore;
			this.mathScore = mathScore;
		}
	}
}