import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, D, K, C, num, count;
	static int[] dish, sushi;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 접시 수
		N = Integer.parseInt(st.nextToken());
		// 가짓수
		D = Integer.parseInt(st.nextToken());
		// 연속해서 먹는 접시 개수
		K = Integer.parseInt(st.nextToken());
		// 쿠폰 번호
		C = Integer.parseInt(st.nextToken());
		dish = new int[N+K];
		sushi = new int[D+1];
		// 접시 채우기
		for (int i=0; i<N; i++){
			dish[i] = Integer.parseInt(br.readLine());
		}
		for (int i=0; i<K; i++){
			dish[N+i] = dish[i];
		}

		//처음 창문 채우기
		int count = 0;
		int result = 0;
		for (int i=0; i<K; i++){
			if (sushi[dish[i]] == 0){
				count++;
			}
			sushi[dish[i]]++;
		}
		if (sushi[C] == 0){
			result = count + 1;
		} else {
			result = count;
		}

		//창문 돌리기
		int start = 0;
		int end = K;
		while (true){
			//처음에 먹은것 뺀다
			sushi[dish[start]] -- ;
			//같은 종류를 이미 먹은게 아니라면 count에서 빼준다.
			if (sushi[dish[start]] == 0) count--;

			if (sushi[dish[end]] == 0) count++;
			sushi[dish[end]] ++;

			if (sushi[C] == 0){
				result = Math.max(result, count + 1);
			} else {
				result = Math.max(result, count);
			}

			start++;
			end++;
			if (end == N+K) {
				break;
			}

		}
		System.out.println(result);
	}
}
