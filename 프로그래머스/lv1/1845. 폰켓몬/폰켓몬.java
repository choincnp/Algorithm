import java.util.*;
class Solution {
    public int solution(int[] nums) {
        Set<Integer> ponketmon = new HashSet<>();
        for (int num : nums){
            ponketmon.add(num);
        }
        return (nums.length/2<=ponketmon.size() ? nums.length/2 : ponketmon.size());
    }
}