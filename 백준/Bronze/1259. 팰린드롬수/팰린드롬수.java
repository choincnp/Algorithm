import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		while (true) {
			String num = sc.nextLine();
			if (num.equals("0")){
				break;
			} else {
				StringBuilder sb = new StringBuilder();
				for (int i = 1; i <= num.length() / 2; i++){
					sb.append(num.charAt(num.length() - i));
				}
				if (num.substring(0,num.length()/2).equals(sb.toString())){
					System.out.println("yes");
				} else {
					System.out.println("no");
				}
			}
		}
	}
}