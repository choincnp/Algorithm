import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] entry;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		entry = new int[N];
		for (int i=0; i<N; i++){
			entry[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(entry);
		long start = 0;
		long mid = 0;
		long end = 1000000000000000001l;
		while (start <= end){
			mid = (start + end) / 2;
			long count = 0;
			for (int i=0; i<N; i++){
				count += mid/entry[i];
				if (count > M) break;
			}
			//받을수 있는 사람이 승객보다 적다면 총 시간 늘려줘야함
			if (count >= M){
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		end = Math.min(end, mid);
		//최소 시간 출력
		System.out.println(end+1);
	}
}