import java.util.stream.*;
class Solution {
    public int solution(int[] num_list) {
        return IntStream
            .rangeClosed(0, num_list.length-1)
            .filter(i -> num_list[i]<0)
            .findFirst()
            .orElse(-1);
    }
}