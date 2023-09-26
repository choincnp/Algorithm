import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int[] A = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++){
			A[i] = Integer.parseInt(st.nextToken());
		}
		int m = Integer.parseInt(br.readLine());
		int[] B = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<m; i++){
			B[i] = Integer.parseInt(st.nextToken());
		}
		Map<Long, Long> mapA = new HashMap<>();
		Map<Long, Long> mapB = new HashMap<>();
		for (int i=0; i<n; i++){
			long sum = 0;
			for (int j=i; j<n; j++){
				sum += A[j];
				long count = mapA.getOrDefault(sum, 0L);
				mapA.put(sum, count+1);
			}
		}
		for (int i=0; i<m; i++){
			long sum = 0;
			for (int j=i; j<m; j++){
				sum += B[j];
				long count = mapB.getOrDefault(sum, 0L);
				mapB.put(sum, count+1);
			}
		}
		long answer = 0;
		for (Map.Entry<Long, Long> entryA :mapA.entrySet()){
			Long aSum = entryA.getKey();
			Long aCount = entryA.getValue();
			long diff = T - aSum;
			Long bCount = mapB.getOrDefault(diff, 0L);
			answer += (aCount * bCount);
		}
		System.out.println(answer);
	}
}