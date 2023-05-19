import java.util.*;
class Solution {
    public int solution(int[] num_list) {
        return Arrays.stream(num_list)
            .reduce(0, (a,b) -> a + count(b));
    }
    public static int count(int n){
        int count = 0;
        while (n > 1){
            if (n%2==0) {
                n /= 2;
                count++;
            } else {
                n = (n-1)/2;
                count++;
            }
        }
        return count;
    }
}