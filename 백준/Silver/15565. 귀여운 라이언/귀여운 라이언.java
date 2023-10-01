import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] doll = new int[N];
		ArrayList<Integer> ryan = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++){
			doll[i] = Integer.parseInt(st.nextToken());
			if (doll[i] == 1) ryan.add(i);
		}
		if (ryan.size() < K) {
			System.out.println("-1");
			return;
		}
		int start = 0;
		int end = K-1;
		int min = Integer.MAX_VALUE;
		int count = 0;
		while (end != ryan.size()) {
			count = ryan.get(end) - ryan.get(start) + 1;
			min = Math.min(min, count);
			start++;
			end++;
		}
		System.out.println(min);
	}
}
