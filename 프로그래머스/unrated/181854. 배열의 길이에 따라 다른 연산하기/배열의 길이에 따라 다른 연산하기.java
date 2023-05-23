import java.util.stream.*;
class Solution {
    public int[] solution(int[] arr, int n) {
        IntStream.range(0, arr.length)
			.filter(arr.length%2 == 0 ? i -> i%2 == 1 : i -> i%2 == 0)
			.forEach(i -> arr[i] += n);
        return arr;
    }
}