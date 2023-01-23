import java.util.*;
class Solution {
    public long solution(long n) {
        long answer = 0L;
        String tmp = ""+n;
        long[] tmp1 = new long[tmp.length()];
        int cnt = 0;
        while (n>0){
            tmp1[cnt] = (long)n%10;
            n/=10;
            cnt++;
        }
        Arrays.sort(tmp1);
        for (int i=0; i<tmp1.length;i++){
            answer += Math.pow(10,i)*tmp1[i];
        }
        return answer;
    }
}