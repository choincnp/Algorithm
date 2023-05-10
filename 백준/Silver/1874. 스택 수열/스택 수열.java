import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i=0; i<N; i++){
			arr[i] = sc.nextInt();
		}
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		int num = 1;
		boolean result = true;
		for (int i=0; i<arr.length; i++){
			int stackNum = arr[i];
			if (stackNum >= num){
				while (stackNum >= num){
					stack.push(num++);
					sb.append("+\n");
				}
				stack.pop();
				sb.append("-\n");
			} else {
				int n = stack.pop();
				if (n > stackNum){
					System.out.println("NO");
					result = false;
					break;
				} else {
					sb.append("-\n");
				}
			}
		}
		if (result){
			System.out.println(sb.toString());
		}
	}
}
