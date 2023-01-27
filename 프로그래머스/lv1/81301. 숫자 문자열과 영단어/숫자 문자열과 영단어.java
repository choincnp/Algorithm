import java.util.*;
class Solution {
    public int solution(String s){
        String answer = "";
        s = s.replaceAll("\"", "");
        Map<String,String> map = new HashMap<>();
        map.put("zero","0");
        map.put("one","1");
        map.put("two","2");
        map.put("three","3");
        map.put("four","4");
        map.put("five","5");
        map.put("six","6");
        map.put("seven","7");
        map.put("eight","8");
        map.put("nine","9");
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<s.length();i++){
            if ('0'<=s.charAt(i)&&s.charAt(i)<='9') answer += s.charAt(i);
            else sb.append(s.charAt(i));
            if (map.containsKey(sb.toString())){
                answer += map.get(sb.toString());
                sb.setLength(0);
            }
        }
        return Integer.parseInt(answer);
    }
}