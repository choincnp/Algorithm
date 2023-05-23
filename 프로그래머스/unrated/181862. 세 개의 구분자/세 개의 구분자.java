import java.util.*;
import java.util.stream.*;
class Solution {
    public String[] solution(String myStr) {
        String[] result = Arrays
            .stream(myStr.split("[a-c]"))
            .filter(i -> !i.equals(""))
            .toArray(String[]::new);
        return result.length == 0 ? new String[]{"EMPTY"} : result;
    }
}