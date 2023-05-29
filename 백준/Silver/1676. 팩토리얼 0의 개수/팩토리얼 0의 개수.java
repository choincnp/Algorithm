import java.io.IOException;
import java.util.Scanner;

public class Main {
	static int[] arr = new int[3];
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		while (num >= 2){
			count(num--);
		}
		System.out.println(arr[0]+Math.min(arr[1],arr[2]));
	}
	public static void count(int num){
		while (num > 2){
			if (num % 10 == 0) {
				num /= 10;
				arr[0]++;
			} else if (num % 5 == 0){
				num /= 5;
				arr[2]++;
			} else if (num % 2 == 0){
				num /= 2;
				arr[1]++;
			} else {
				break;
			}
		}
	}
}