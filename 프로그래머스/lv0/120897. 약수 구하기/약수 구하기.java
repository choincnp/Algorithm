import java.util.*;
class Solution {
    public Set solution(int n) {
        Set<Integer> arr = new TreeSet();
        for (int i=1; i<= Math.sqrt(n); i++){
            if (n%i==0){
                arr.add(i);
                arr.add(n/i);
            }
        }
        return arr;
    }
}