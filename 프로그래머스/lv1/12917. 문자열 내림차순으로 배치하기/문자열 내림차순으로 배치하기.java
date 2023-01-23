import java.util.*;
class Solution {
    public String solution(String s) {
        String[] answer = s.split("");
        Arrays.sort(answer,Collections.reverseOrder()); 
        return String.join("", answer);
    }
}