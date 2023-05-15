import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][2];
		for (int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1]==o2[1]){
					return o1[0]-o2[0];
				} else {
					return o1[1]-o2[1];
				}
			}
		});
		int count = 0;
		int end = -1;
		for (int i=0; i<N; i++){
			if (arr[i][0]>=end){ // 겹치지 않는 회의가 나온 경우
				end = arr[i][1]; // 종료 시간 업데이트하기
				count++;
			}
		}
		System.out.println(count);
	}
}