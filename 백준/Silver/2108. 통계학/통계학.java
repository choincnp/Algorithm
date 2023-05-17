import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		ArrayList<Integer> numbers = new ArrayList<>();
		int[] count = new int[8001];
		long avg = 0;
		int max = Integer.MIN_VALUE;
		for (int i=0; i<N; i++){
			int num = Integer.parseInt(br.readLine());
			numbers.add(num);
			count[num+4000]++;
			avg += num;
		}
		int min = 0;
		boolean flag = false;
		for (int i=-4000; i<=4000; i++){
			if (max < count[i+4000]){
				max = count[i+4000];
				min = i;
				flag = true;
			} else if (max == count[i+4000] && flag){
				min = i;
				flag = false;
			}
		}
		Collections.sort(numbers);
		StringBuilder sb = new StringBuilder();
		sb.append((int)Math.round((double)avg/N)).append("\n");
		sb.append(numbers.get((N-1)/2)).append("\n");
		sb.append(min).append("\n");
		sb.append(numbers.get(N-1)-numbers.get(0)).append("\n");
		System.out.println(sb);


	}
}