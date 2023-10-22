import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println(factorial(N));
	}
	static int factorial(int x){
		if (x==1 || x==0) return 1;
		else return x*factorial(x-1);
	}
}
