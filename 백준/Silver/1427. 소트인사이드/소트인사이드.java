import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num = br.readLine();
		int[] arr = new int[num.length()];
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<num.length(); i++) {
			arr[i] = num.charAt(i) - '0';
		}
		for (int i=0; i<num.length(); i++){
			int min = 10;
			int idx = 0;
			for (int j=i; j<num.length(); j++){
				if (arr[j] < min ){
					min = arr[j];
					idx = j;
				}
			}
			int tmp = arr[i];
			arr[i] = arr[idx];
			arr[idx] = tmp;
		}
		for (int i=0; i<num.length(); i++){
			sb.append(arr[i]);
		}
		System.out.println(sb.reverse().toString());
	}
}