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
		for (int i=0; i<N; i++){
			Stack<String> stack = new Stack<>();
			String str = br.readLine();
			boolean flag = true;
			for (int j=0; j<str.length(); j++){
				if (str.charAt(j) == '('){
					stack.push("(");
				} else if (str.charAt(j) == ')'){
					if (stack.isEmpty()){
						System.out.println("NO");
						flag = false;
						break;
					} else {
						stack.pop();
					}
				}
			}
			if (flag) System.out.println(stack.isEmpty() ? "YES" : "NO");
		}
	}
}
