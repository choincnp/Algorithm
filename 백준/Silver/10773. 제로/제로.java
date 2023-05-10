import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		Stack<Integer> stack = new Stack<>();
		for (int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			if (command == 0){
				stack.pop();
			} else {
				stack.push(command);
			}
		}
		System.out.println(stack.isEmpty() ? 0 : stack.stream().mapToInt(Integer::intValue).sum());
	}
}