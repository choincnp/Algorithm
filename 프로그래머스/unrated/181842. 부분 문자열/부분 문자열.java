import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(String str1, String str2) {
        return Arrays.stream(str2.split("")).collect(Collectors.joining()).contains(str1) ? 1 : 0;
    }
}