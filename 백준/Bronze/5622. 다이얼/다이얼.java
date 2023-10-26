import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int sum = 0;
		for (int i=0; i<s.length(); i++){
			char c = s.charAt(i);
			if (c == '1') sum += 2;
			else if ('A' <= c && c<= 'C') sum += 3;
			else if ('D' <= c && c <= 'F') sum += 4;
			else if ('G' <= c && c <= 'I') sum += 5;
			else if ('J' <= c && c <= 'L') sum += 6;
			else if ('M' <= c && c <= 'O') sum += 7;
			else if ('P' <= c && c <= 'S') sum += 8;
			else if ('T' <= c && c <= 'V') sum += 9;
			else if ('W' <= c && c <= 'Z') sum += 10;
		}
		System.out.println(sum);
	}
}