class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i=2 ; i<=n ; i++){
            if (isPrime(i)){answer++;}
        }
        return answer;
    }
    static boolean isPrime(int a){
        for (int i=2; i<=Math.sqrt(a);i++){
            if(a%i == 0) return false;
        }
        return true;
    }
}