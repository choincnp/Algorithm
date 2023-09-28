import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	//idea
	//층수마다 dp설정 + 내려가는 점수 2차배열로 최대, 최소 설정해놓기
	static int[][] dpMax;
	static int[][] dpMin;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		dpMax = new int[T][3];
		dpMin = new int[T][3];
		for (int i=0; i<T; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			if (i==0) {
				dpMax[0][0] = dpMin[0][0] = A;
				dpMax[0][1] = dpMin[0][1] = B;
				dpMax[0][2] = dpMin[0][2] = C;

			} else {
				dpMax[i][0] = Math.max(dpMax[i-1][0], dpMax[i-1][1]) + A;
				dpMax[i][1] = Math.max(dpMax[i-1][0], Math.max(dpMax[i-1][1], dpMax[i-1][2])) + B;
				dpMax[i][2] = Math.max(dpMax[i-1][1], dpMax[i-1][2]) + C;

				dpMin[i][0] = Math.min(dpMin[i-1][0], dpMin[i-1][1]) + A;
				dpMin[i][1] = Math.min(dpMin[i-1][0], Math.min(dpMin[i-1][1], dpMin[i-1][2])) + B;
				dpMin[i][2] = Math.min(dpMin[i-1][1], dpMin[i-1][2]) + C;
			}
		}
		int max = Math.max(dpMax[T-1][0], Math.max(dpMax[T-1][1], dpMax[T-1][2]));
		int min = Math.min(dpMin[T-1][0], Math.min(dpMin[T-1][1], dpMin[T-1][2]));
		sb.append(max).append(" ").append(min);
		System.out.println(sb.toString());



	}
}