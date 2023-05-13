import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
		int i=0;
		while (true){
			if (i == arr.length) break;
			else if (stack.isEmpty()){
				stack.add(arr[i]);
				i++;
			} else if ((!stack.isEmpty())&&(stack.peek()<arr[i])){
				stack.push(arr[i]);
				i++;
			} else {
				stack.pop();
			}
		}
		return stack.stream().mapToInt(Integer::intValue).toArray();
    }
}