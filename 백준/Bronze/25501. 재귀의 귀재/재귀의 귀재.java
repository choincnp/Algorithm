import java.io.IOException;
import java.util.Scanner;

public class Main {
	static int count;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		for (int i=0; i<num; i++){
			count = 0;
			System.out.println(isPalindrome(sc.next())+" "+count);
		}
		sc.close();
	}
	public static int isPalindrome(String str){
		return recursion(str, 0, str.length()-1);
	}
	public static int recursion(String str, int start, int end){
		count++;
		if (start >= end) return 1;
		else if (str.charAt(start) != str.charAt(end)) return 0;
		else return recursion(str, start+1, end-1);
	}
}