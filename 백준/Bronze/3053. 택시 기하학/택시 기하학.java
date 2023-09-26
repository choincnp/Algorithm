import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		System.out.printf("%.6f\n",Math.PI * Math.pow(R, 2));
		System.out.printf("%.6f", 2 * Math.pow(R, 2));
	}
}