import java.util.stream.*;
class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        for (int i=0; i< queries.length; i++){
			IntStream
				.rangeClosed(queries[i][0], queries[i][1])
				.forEach(j -> arr[j]++);
		}
        return arr;
    }
}