import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        Arrays.sort(arr);
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i : arr)
            if (i%divisor==0) answer.add(i);
        if (answer.size()==0) answer.add(-1);
        return answer.stream().mapToInt(i->i).toArray();
    }
}