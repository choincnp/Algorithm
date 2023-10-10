import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	//LIS구하기 - 원소 요구하지 않으므로 DP가 아닌 이분탐색으로
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[] lis = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int index = 0;
		for (int i=0 ; i<N; i++){
			int num = Integer.parseInt(st.nextToken());
			if (i==0) lis[index++] = num;
			if (lis[index-1] < num){
				lis[index++] = num;
			} else {
				int start = 0;
				int end = index;
				while (start < end){
					int mid = (start + end) / 2;
					if (lis[mid] < num){
						start = mid + 1;
					} else {
						end = mid;
					}
				}
				lis[end] = num;
			}
		}
		System.out.println(index);
	}
}
