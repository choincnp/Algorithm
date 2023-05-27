class Solution {
    public int solution(int[][] arr) {
        int[][] arr2 = new int[arr.length][arr.length];
        for (int i=0; i<arr.length; i++){
            for (int j=0; j<arr.length; j++){
                arr2[j][i] = arr[i][j];
            }
        }
        boolean check = true;
        for (int i=0; i<arr.length; i++){
            for (int j=0; j<arr.length; j++){
                if (arr[i][j] != arr[j][i]) check = false;
            }
        }
        return check? 1 : 0;
    }
}