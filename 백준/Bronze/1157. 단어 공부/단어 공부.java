import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine().toLowerCase();
		char answer = ' ';
		int[] alphabet = new int[26];
		for (int i=0; i<input.length(); i++){
			alphabet[input.charAt(i)-'a']++;
		}
		int max = 0;
		for (int i=0; i< alphabet.length; i++){
			if (alphabet[i] > max){
				max = alphabet[i];
				answer = (char)(i+'A');
			} else if (alphabet[i] == max){
				answer = '?';
			}
		}
		System.out.println(answer);
	}
}
