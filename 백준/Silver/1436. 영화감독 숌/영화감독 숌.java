import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int count = 0;
		int start = 666;
		while (true){
			if (count == N) break;
			if (String.valueOf(start).contains("666")) {
				arr[count] = start;
				start++;
				count++;
			} else {
				start++;
			}
		}
		System.out.println(arr[N-1]);
	}
}