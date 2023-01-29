class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        answer[0] = getGCD(n,m);
        answer[1] = m*n/answer[0];
        return answer;
    }
    static int getGCD(int a, int b){
        while(b !=0){
        int r = a%b;
        a = b;
        b = r;
        }
        return a;
    }
}