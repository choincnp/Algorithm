class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int mod = 0;
        while (n>=a){
            answer += (n/a)*b;
            mod = n%a;
            n = (n/a)*b + mod;
        }
        return answer;
    }
}