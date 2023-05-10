import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int V = sc.nextInt();
		int day = (V - B) / (A - B);
		System.out.println((V - B) % (A - B) == 0 ? day : day + 1);
	}
}
