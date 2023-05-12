import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
		Stack<String> stack = new Stack<>();
		if (s.charAt(0) == ')') return false;
		else{
			for (int i=0; i<s.length(); i++){
				if (s.charAt(i) == '(')
					stack.add("(");
				else{
					if (stack.isEmpty()) return false;
					else stack.pop();
				}
			}
		}
		return stack.isEmpty() ? true : false;
    }
}