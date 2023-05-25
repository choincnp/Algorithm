import java.util.*;
import java.util.stream.*;
class Solution {
    public int[][] solution(int n) {
        return IntStream.range(0,n).mapToObj(i -> IntStream.range(0, n).map(j -> j==i? 1 : 0).toArray()).toArray(int[][]::new);
    }
}