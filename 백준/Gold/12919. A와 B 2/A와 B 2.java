import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static boolean flag;
	static String S, T;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = br.readLine();
		T = br.readLine();
		transform(T);
		System.out.println(flag ? "1" : "0");
	}
	static void transform(String start){
		if (start.equals(S)) {
			flag = true;
			return;
		} else if (start.length() <= S.length()){
			return;
		}
		if (start.endsWith("A")) transform(new StringBuilder(start.substring(0, start.length()-1)).toString());
		if (start.startsWith("B")) transform(new StringBuilder(start).reverse().substring(0, start.length()-1));
	}
}