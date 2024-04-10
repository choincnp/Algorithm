import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		while (N--> 0){
			Stack<Character> stack = new Stack<>();
			String letter = br.readLine();
			for (int i=0; i<letter.length(); i++){
				char lt = letter.charAt(i);
				if (stack.isEmpty()) stack.push(lt);
				else {
					if (stack.peek() == lt) stack.pop();
					else stack.push(lt);
				}
			}
			if (stack.isEmpty()) count++;
		}
		System.out.println(count);
	}
}