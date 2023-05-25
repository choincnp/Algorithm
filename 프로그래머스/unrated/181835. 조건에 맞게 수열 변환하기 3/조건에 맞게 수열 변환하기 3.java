import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int[] arr, int k) {
        return Arrays.stream(arr).map(i-> k%2==0? i+k : i*k).toArray();
    }
}