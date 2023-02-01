class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int zero = 0, matched = 0;
        int max = 1; int min = 6;
        for (int i : lottos){
            if (i==0) zero ++;
            for (int j : win_nums){
                if (i==j) matched++;
            }
        }
        max = Math.min(6, 7-(matched+zero));
        min = Math.min(6, 7-matched);
        int[] answer = {max, min};
        return answer;
    }
}