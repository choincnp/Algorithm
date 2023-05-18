import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true){
			String line = br.readLine();
			if (line.equals(".")) break;
			sb.append(solution(line)).append("\n");
		}
		System.out.println(sb);
	}
	public static String solution(String line){
		Stack<Character> stack = new Stack<>();
		if (line.length() == 0) return "yes";
		for (int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);
			if (c == '(' || c == '[') stack.push(c);
			else if (c == ')') {
				if (stack.isEmpty() || stack.peek() != '(') return "no";
				stack.pop();
			}
			else if (c == ']') {
				if (stack.isEmpty() || stack.peek() != '[') return "no";
				stack.pop();
			}
		}
		return (stack.isEmpty()) ? "yes" : "no";
	}
}