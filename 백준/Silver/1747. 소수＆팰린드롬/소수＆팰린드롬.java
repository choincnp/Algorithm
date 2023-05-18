import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[10000001];
		for (int i=2; i<arr.length; i++){
			arr[i] = i;
		}
		for (int i=2; i<Math.sqrt(arr.length); i++){
			if (arr[i] == 0) continue;
			for (int j=i+i; j<arr.length; j = j+i){
				arr[j] = 0;
			}
		}
		int i= N;
		while (true){
			if (arr[i] != 0 && isPalindrome(i)){
				System.out.println(i);
				break;
			}
			i++;
		}
	}
	public static boolean isPalindrome(int n){
		String str = String.valueOf(n);
		StringBuilder sb = new StringBuilder();
		sb.append(str.substring((str.length()+1)/2, str.length()));
		if (str.substring(0, str.length()/2).equals(sb.reverse().toString()))
			return true;
		else
			return false;
	}
}