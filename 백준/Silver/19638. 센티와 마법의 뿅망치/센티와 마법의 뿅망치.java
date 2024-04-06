import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// 뿅망치에 맞은 사람의 키가 ⌊ 뿅망치에 맞은 사람의 키 / 2 ⌋로 변하는 마법 도구
		// 단, 키가 1인 경우 더 줄어들 수가 없어 뿅망치의 영향을 받지 않는다. 횟수 제한이 있다.
		// 매번 가장 키가 큰 거인 가운데 하나를 때리는 것
		// 거인의 나라의 모든 거인이 센티보다 키가 작도록 할 수 있을까?

        /*
        모든거인이 센티보다 작아지면 YES + 마법의 뿅망치를 최소로 사용한 횟수
        센티보다 키가 크거나 같은 거인이 있는 경우 NO + 키가 가장 큰 거인의 키


        [출력 내용]
         N (거인나라 인구수)  |  H (센티의 키)  |  T (마법의 뿅망치 횟수 제한)
         두 번째 줄부터 N개의 줄에 각 거인의 키
        */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());   // 거인 인구수
		long H = Long.parseLong(st.nextToken());   // 센티키
		int T = Integer.parseInt(st.nextToken());   // 뿅망치 횟수제한
		PriorityQueue<Integer> giants = new PriorityQueue<>(Collections.reverseOrder());

		// 거인 키 입력
		while (N-- > 0) {
			giants.add(Integer.parseInt(br.readLine()));
		}

		int max = giants.peek(); // 우선순위중 가장큰값 (삭제X)
		int count = 0;           // 최소 횟수 저장할 변수

		if(max >= H) {

			while(T-- > 0)  {

				if(max==1){
					max = giants.peek();
				} else {
					count++;
					max = giants.poll()/ 2;  // 제일 큰값을 빼서 반으로 망치질
					giants.add(max);
				}
				if (giants.peek() < H) {
					break;
				}
			}
		}
		max = giants.peek();

		if(max < H) {
			bw.write("YES");
			bw.write("\n"+ count);
		} else {
			bw.write("NO");
			bw.write("\n" + max);
		}

		bw.flush();
		bw.close();

	}
}
