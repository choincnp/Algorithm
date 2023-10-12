
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] alphabet = new int[27];
		while (N-- > 0){
			String num = br.readLine();
			for (int i=0; i<num.length(); i++){
				alphabet[num.charAt(i)-'A'] += Math.pow(10, num.length()-i-1);
			}
		}
		Arrays.sort(alphabet);
		int sum = 0;
		int length = alphabet.length-1;
		for (int i=9; i>=0; i--){
			sum += alphabet[length--] * i;
		}
		System.out.println(sum);
	}
}
