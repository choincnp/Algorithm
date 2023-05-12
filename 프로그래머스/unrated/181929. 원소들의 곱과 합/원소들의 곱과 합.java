import java.util.*;
class Solution {
    public int solution(int[] num_list) {
        int hap = (int)Math.pow(Arrays.stream(num_list).map(i->i).sum(),2);
        int gop = Arrays.stream(num_list).reduce(1, (a,b) -> a*b);
        return hap > gop ? 1 : 0;
    }
}