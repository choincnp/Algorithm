import java.util.*;
import java.util.stream.*;
class Solution {
    public String[] solution(String[] picture, int k) {
        return Arrays.stream(picture).map(i -> i.chars().mapToObj(c -> String.valueOf((char)c).repeat(k)).collect(Collectors.joining())).flatMap(i -> Collections.nCopies(k, i).stream()).toArray(String[]::new);
    }
}