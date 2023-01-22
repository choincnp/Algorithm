import java.util.*;
class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int length = board.length;
        int[][] board2 = new int[length+2][length+2];
        for (int i=0; i<board2.length;i++){
            Arrays.fill(board2[i],0);
        }
        for (int i=0;i<length;i++){
            for (int j=0;j<length;j++){
                if (board[i][j]==1){
                    for (int k=-1;k<=1;k++){
                        for(int l=-1;l<=1;l++){
                            board2[i+k+1][j+l+1] += 1;
                        }
                    }
                }
            }
        }
        for (int i=1;i<=length;i++){
            for (int j=1;j<=length;j++){
                if (board2[i][j]==0) answer++;
            }
        }
        return answer;
    }
}