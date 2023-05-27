class Solution {
    public int solution(int[][] arr) {
        for (int i=0; i<arr.length; i++){
            for (int j=0; j<i; j++){
                if (arr[i][j] != arr[j][i]) return 0;
            }
        }
        return 1;
    }
}