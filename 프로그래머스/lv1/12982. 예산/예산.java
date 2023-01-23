import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int i=0;
        Arrays.sort(d);
        while (budget>0){
            budget -= d[i];
            if (budget>=0) answer++;
            if (budget<0 || i==d.length-1) break;
            i++;
        }
        return answer;
    }
}