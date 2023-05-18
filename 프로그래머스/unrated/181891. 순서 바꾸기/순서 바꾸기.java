import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int[] num_list, int n) {
        return Stream
            .concat(
            Arrays.stream(Arrays.copyOfRange(num_list, n, num_list.length)).boxed()
                    , Arrays.stream(Arrays.copyOfRange(num_list,0,n)).boxed())
            .mapToInt(Integer::intValue)
            .toArray();
    }
}