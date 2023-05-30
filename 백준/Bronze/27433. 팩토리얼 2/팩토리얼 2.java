import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		long num = sc.nextLong();
		System.out.println(factorial(num));

	}
	public static long factorial(long num){
		if(num == 0) return 1;
		return num * factorial(num - 1);
	}
}