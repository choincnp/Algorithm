import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int[] arr, boolean[] flag) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i=0; i<flag.length; i++){
            if (flag[i]) {
                for (int j=0; j<2*arr[i]; j++) result.add(arr[i]);
            } else {
                for (int j=0; j<arr[i]; j++) result.remove(result.size()-1);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}