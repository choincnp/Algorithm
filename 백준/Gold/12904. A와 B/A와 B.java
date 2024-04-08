import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	/*
	 * B에서 A로 가보자
	 *
	 */
	static boolean flag;
	static String A;
	static String B;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		A = br.readLine();
		B = br.readLine();
		swap(B);
		System.out.println(flag ? "1" : "0");
	}
	static void swap(String start){
		if (start.equals(A)) {
			flag = true;
		}
		if (start.length() > A.length()){
			if (start.charAt(start.length() - 1) == 'A') {
				swap(start.substring(0, start.length() - 1));
			}
			if (start.charAt(start.length() - 1) == 'B') {
				swap(new StringBuilder(start.substring(0, start.length() - 1)).reverse().toString());
			}
		}
	}
}