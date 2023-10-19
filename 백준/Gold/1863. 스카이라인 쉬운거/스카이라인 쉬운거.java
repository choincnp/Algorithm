import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		Stack<int[]> stack = new Stack<>();
		int count = 0;
		for (int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			while (!stack.isEmpty() && stack.peek()[1] > y){
				count++;
				stack.pop();
			}
			if (!stack.isEmpty() && stack.peek()[1] == y){
				continue;
			}
			if (y != 0){
				stack.push(new int[]{x, y});
			}
		}
		count += stack.size();
		System.out.println(count);
	}
}
