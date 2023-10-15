import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[] dist = new int[N-1];
		int[] station = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N-1; i++){
			dist[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++){
			station[i] = Integer.parseInt(st.nextToken());
		}
		long sum = 0;
		long cost = station[0];
		for (int i=0; i<N-1; i++){
			if (station[i] < cost){
				cost = station[i];
			}
			sum += cost * dist[i];
		}
		System.out.println(sum);
	}
}
