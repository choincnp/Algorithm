import java.util.*;
class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for (int i=left; i<=right; i++){
            if (yaksu(i)%2==0) answer += i;
            else answer -= i;
        }
        return answer;
    }
    static int yaksu(int a){
        int result=0;
        for (int i=1; i<Math.sqrt(a); i++){
            if (a%i==0) result++;
        }
        return Math.sqrt(a)%1==0? result*2+1 : result*2;
    }
}