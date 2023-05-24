import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int[] num_list) {
        return Arrays.stream(num_list).sorted().skip(5).toArray();
    }
}