import java.util.*;
class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i=0; i<intStrs.length; i++){
            int tmp = Integer.parseInt(intStrs[i].substring(s,s+l));
            if (tmp > k) result.add(tmp);
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}