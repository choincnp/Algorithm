import java.util.stream.*;
class Solution {
    public String[] solution(String[] names) {
        return IntStream
            .rangeClosed(0,names.length-1)
            .filter(i -> i%5==0)
            .mapToObj(i -> names[i])
            .toArray(String[]::new);
    }
}