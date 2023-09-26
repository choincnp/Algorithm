import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		switch (A+B+C){
			case 180:
				if (A==B && B==C){
					System.out.println("Equilateral");
				} else if (A==B || B==C || C==A) {
					System.out.println("Isosceles");
				} else {
					System.out.println("Scalene");
				}
				break;
			default:
				System.out.println("Error");
		}
	}
}