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
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		int[] bigger = new int[N];
		int[] answer = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++){
			bigger[i] = Integer.parseInt(st.nextToken());
		}
		stack.push(0);
		for (int i=1; i<N; i++){
			while(!stack.isEmpty() && bigger[stack.peek()] < bigger[i]){
				answer[stack.pop()] = bigger[i];
			}
			if (!stack.isEmpty()){
				answer[i] = -1;
			}
			stack.push(i);
		}
		for (int i=0; i<N; i++){
			sb.append(answer[i] == 0 ? -1 : answer[i]).append(" ");
		}
		System.out.println(sb.toString());
	}
}
