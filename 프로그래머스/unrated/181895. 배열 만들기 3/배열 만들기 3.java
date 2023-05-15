import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        ArrayList<Integer> answer = new ArrayList<>();
        for (int j=0; j<intervals.length; j++){
            IntStream
                .rangeClosed(intervals[j][0],intervals[j][1])
                .forEach(i -> answer.add(arr[i]));
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}