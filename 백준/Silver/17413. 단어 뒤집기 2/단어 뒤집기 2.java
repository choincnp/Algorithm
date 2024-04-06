import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		/*
		 * 1. 알파벳 소문자('a'-'z'), 숫자('0'-'9'), 공백(' '), 특수 문자('<', '>')로만 이루어져 있다.
		 * 2. 문자열의 시작과 끝은 공백이 아니다.
		 * '<'와 '>'가 문자열에 있는 경우 번갈아가면서 등장하며, '<'이 먼저 등장한다. 또, 두 문자의 개수는 같다.
		 * 풀이 방식
		 * 1. <가 있을경우 안의 문자는 그대로
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String letter = br.readLine();
		Stack<Character> stack = new Stack<>();
		boolean flag = false;
		for (int i=0; i<letter.length(); i++){
			char word = letter.charAt(i);
			if (word == '<'){
				while (!stack.isEmpty()){
					sb.append(stack.pop());
				}
				sb.append("<");
				flag = true;
			} else if (word == ' '){
				while (!stack.isEmpty()){
					sb.append(stack.pop());
				}
				sb.append(' ');
			} else if (word == '>'){
				while (!stack.isEmpty()){
					sb.append(stack.pop());
				}
				sb.append(">");
				flag = false;
			} else if (flag){
				sb.append(word);
			} else {
				stack.push(word);
			}
		}
		while (!stack.isEmpty()){
			sb.append(stack.pop());
		}
		System.out.println(sb);
	}
}