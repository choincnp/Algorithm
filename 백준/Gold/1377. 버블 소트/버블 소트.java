import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		data[] arr = new data[N];
		for (int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			arr[i] = new data(Integer.parseInt(st.nextToken()), i);
		}
		Arrays.sort(arr);
		int max = 0;
		for (int i=0; i<N; i++){
			if (max < arr[i].index - i)
				max = arr[i].index - i;
		}
		System.out.println(max+1);
	}
}
class data implements Comparable<data>{
	int value;
	int index;
	public data(int value, int index){
		this.value = value;
		this.index = index;
	}
	@Override
	public int compareTo(data o) {
		return this.value - o.value;
	}
}
