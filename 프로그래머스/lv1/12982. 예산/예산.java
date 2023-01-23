import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int i=0;
        Arrays.sort(d);
        for (int f : d){
            budget -= f;
            if (budget < 0) break;
            answer++;
        }
        return answer;
    }
}