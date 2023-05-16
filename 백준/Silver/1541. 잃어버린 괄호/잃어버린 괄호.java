import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String[] split = input.split("-");
		int sum = 0;
		for (int i=0; i< split.length; i++){
			int num = Arrays.stream(split[i].split("[+]")).mapToInt(Integer::parseInt).sum();
			if (i==0){
				sum += num;
			}
			else{
				sum -= num;
			}
		}
		System.out.println(sum);
	}
}