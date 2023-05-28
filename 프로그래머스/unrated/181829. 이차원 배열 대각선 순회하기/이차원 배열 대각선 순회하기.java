import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int[][] board, int k) {
        return IntStream.range(0, board.length)
            .map(i -> IntStream.rangeClosed(0, board[i].length-1)
                 .filter(j -> i+j<=k)
                 .map(j -> board[i][j])
                 .sum())
            .sum();
    }
}