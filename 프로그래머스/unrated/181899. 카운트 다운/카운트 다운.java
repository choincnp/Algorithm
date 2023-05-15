import java.util.*;
class Solution {
    public int[] solution(int start, int end) {
        ArrayList<Integer> result = new ArrayList<>();
        while (start >= end){
            result.add(start);
            start--;
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}