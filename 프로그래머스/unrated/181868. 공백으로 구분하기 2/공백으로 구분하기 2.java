import java.util.*;
class Solution {
    public String[] solution(String my_string) {
        return Arrays.stream(my_string.trim().replaceAll("  "," ").split(" "))
            .filter(s -> !s.equals(""))
            .toArray(String[]::new);
    }
}