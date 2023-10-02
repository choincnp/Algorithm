import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] list = new int[N];
		int[] sort = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++){
			list[i] = sort[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(sort);
		HashMap<Integer, Integer> map = new HashMap<>();
		int rank = 0;
		for (int i=0; i<N; i++){
			if (!map.containsKey(sort[i])){
				map.put(sort[i], rank++);
			}
		}
		for (int i=0; i<N; i++){
			sb.append(map.get(list[i])).append(" ");
		}
		System.out.println(sb.toString());
	}
}
