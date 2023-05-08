import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int answer = 0;
		for (int i=0; i<5; i++){
			int num = sc.nextInt();
			answer = (int)((answer + Math.pow(num, 2))%10);
		}
		System.out.println(answer);
	}
}