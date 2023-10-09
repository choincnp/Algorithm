import java.util.*;
class Solution
{
    public int solution(String s)
    {
        if (s.length()%2 != 0 ) return 0;
        Stack<Character> stack = new Stack<>();
        stack.add(s.charAt(0));
        for (int i=1; i<s.length(); i++){
            if (stack.isEmpty() || stack.peek() != s.charAt(i)){
                stack.push(s.charAt(i));
            } else {
                stack.pop();
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}