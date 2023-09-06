class Solution {
    static int[][] answer;
    static int count;
    public int[][] solution(int n) {
        answer = new int[(int)Math.pow(2,n)-1][2];
        hanoi(n,1,2,3);
        return answer;
    }
    static void hanoi(int n, int start, int mid, int end){
        if(n==1){
            answer[count][0] = start;
            answer[count][1] = end;
            count++;
            return;
        }
        // 먼저 작은것부터 옮김
        hanoi(n-1, start, end, mid);
        answer[count][0] = start;
        answer[count][1] = end;
        count++;
        hanoi(n-1, mid, start, end);
    }
}