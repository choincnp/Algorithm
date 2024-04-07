import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	/*
	 * 게임 횟수 X, 이긴 게임 Y, 승률 Z(정수)
	 * Z >= 99라면 오를 가능성 없음(소수점 버림)
	 * MAX = X로 처음에 잡아준다.
	 * 이분 탐색으로 풀어본다.
	 */

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long x = Long.parseLong(st.nextToken());
		long y = Long.parseLong(st.nextToken());
		int z = (int)((double)y * 100 / x );
		if (z >= 99){
			System.out.println(-1);
			return;
		}
		int start = 0;
		int end = (int)x;
		int res = -1;
		while (start <= end){
			int mid = (start + end) / 2;
			int percentage = (int)((double)(y + mid) * 100 / (x + mid));
			if (percentage <= z){
				start = res = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		System.out.println(res);
	}
}
