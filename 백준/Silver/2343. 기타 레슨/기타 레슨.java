import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[] lecture = new int[N];
		int min = 0;
		int max = 0;
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++){
			lecture[i] = Integer.parseInt(st.nextToken());
			if (lecture[i] > min){
				min = lecture[i];
			}
			max += lecture[i];
		}
		int start = min;
		int end = max;
		while (start <= end){
			int mid = (start + end) / 2;
			int sum = 0;
			int count = 0;
			for (int i=0; i<N; i++){
				if (sum + lecture[i] > mid){
					count++;
					sum = 0;
				}
				sum += lecture[i];
			}
			if (sum != 0){
				count++;
			}
			if (count > M){
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		System.out.println(start);
	}
}