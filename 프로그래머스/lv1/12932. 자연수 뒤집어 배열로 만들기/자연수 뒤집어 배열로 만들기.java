import java.util.*;
class Solution {
    public long[] solution(long n) {
        ArrayList<Long> arr = new ArrayList();
        while (n>0){
            arr.add((long)n%10);
            n /= 10;
        }
        return arr.stream().mapToLong(i -> i).toArray();
    }
}