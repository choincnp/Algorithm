class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i=1; i<n+1; i++){
            if (((double)n/i)%1==0) answer += i;
            else;
        }
        return answer;
    }
}