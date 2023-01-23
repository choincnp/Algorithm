class Solution {
    public int solution(int n) {
        int answer=0;
        for (int i=1; i<=n;i++){
            if (yaksunum(i)>=3) answer++;
        }
        return answer;
    }
    static int yaksunum(int a){
        int cnt=0;
        for (int i=1; i<Math.sqrt(a);i++){if ((a%i)==0) cnt += 2;}
        if (a%Math.sqrt(a)==0) cnt++;
        return cnt;
    }
}