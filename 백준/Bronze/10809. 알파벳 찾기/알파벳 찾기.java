import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		for (int i = 0; i < 26; i++){
			if (i != 25){
				System.out.print(s.indexOf((char)(i + 97)) + " ");
			} else {
				System.out.print(s.indexOf((char)(i + 97)));
			}
		}
	}
}
