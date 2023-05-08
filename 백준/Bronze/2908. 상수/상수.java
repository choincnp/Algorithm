import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String d = "";
		for (int i=s.length()-1; i>=0; i--){
			d += s.charAt(i);
		}
		String[] arr = d.split(" ");
		if (Integer.parseInt(arr[0]) > Integer.parseInt(arr[1])){
			System.out.println(arr[0]);
		} else {
			System.out.println(arr[1]);
		}
	}
}
