import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, num;
	static int[] dic;
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		dic = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++){
			dic[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(dic);
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		while (M -- > 0){
			num = Integer.parseInt(st.nextToken());
			sb.append(BS(num)).append(" ");
		}
		System.out.println(sb.toString());
	}
	static int BS(int num){
		int l = 0;
		int r = N-1;
		while (l <= r){
			int mid = (l+r)/2;
			if (dic[mid] == num){
				return 1;
			} else if (dic[mid] < num){
				l = mid + 1;
			} else{
				r = mid - 1;
			}
		}
		return 0;
	}

}
