import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] heights = new int[N];
		for (int i = 0; i < N; i++) {
			heights[i] = Integer.parseInt(br.readLine());
		}

		System.out.println(largestRectangleArea(heights));
	}

	public static int largestRectangleArea(int[] heights) {
		Stack<Integer> stack = new Stack<>();
		int maxArea = 0;

		for (int i = 0; i <= heights.length; i++) {
			int h = (i == heights.length) ? 0 : heights[i];
			if (stack.isEmpty() || h >= heights[stack.peek()]) {
				stack.push(i);
			} else {
				int top = stack.pop();
				maxArea = Math.max(maxArea, heights[top] * (stack.isEmpty() ? i : i - 1 - stack.peek()));
				i--;
			}
		}

		return maxArea;
	}
}
