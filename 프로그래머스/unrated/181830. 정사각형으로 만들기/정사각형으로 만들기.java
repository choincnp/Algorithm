import java.util.*;
class Solution {
    public int[][] solution(int[][] arr) {
        int max = arr.length;
		for (int i=0; i<arr.length; i++){
			max = Math.max(max, arr[i].length);
		}
		int[][] newArr = new int[max][max];
		for (int i=0; i<max; i++){
			Arrays.fill(newArr[i], 0);
		}
		for (int i=0; i<arr.length; i++){
			for (int j=0; j<arr[i].length; j++){
				newArr[i][j] = arr[i][j];
			}
		}
        return newArr;
    }
}