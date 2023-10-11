class Solution {
    public int[][] solution(int n) {
        int[][] field = new int[n][n];
        int index = 1;
        int x = 0;
        int y = 0;
        if (n%2 != 0 ) field[n/2][n/2] = n*n;
        while (n >= 0){
            for (int i=0; i<n-1; i++){
                field[x][y++] = index++;
            }
            for (int i=0; i<n-1; i++){
                field[x++][y] = index++;
            }
            for (int i=0; i<n-1; i++){
                field[x][y--] = index++;
            }
            for (int i=0; i<n-1; i++){
                field[x--][y] = index++;
            }
            x++;
            y++;
            n -= 2;
        }
        return field;
    }
}