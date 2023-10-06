import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, C;
	static int[] house;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		house = new int[N];
		for (int i=0; i<N; i++){
			house[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(house);
		int start = 1;
		int end = house[N-1]- house[0] + 1;
		while (start <= end){
			int mid = (start + end) / 2;
			//설치 가능 개수가 주어진 갯수보다 적으면 공유기 사이 거리를 내린다.
			if (install(mid) < C){
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		System.out.println(start-1);
	}

	//공유기 설치 가능 개수
	static int install(int mid){
		int count = 1;
		int last = house[0];
		for(int i=1; i<N; i++){
			if (house[i] - last >= mid){
				count++;
				last = house[i];
			}
		}
		return count;
	}

}
