import java.util.stream.*;
class Solution {
    public int[] solution(int[] arr) {
        int sqrt = 0;
        while (true){
            if (Math.pow(2,sqrt) >= arr.length){
                break;
            } else sqrt++;
        }
        return IntStream.range(0,(int)Math.pow(2,sqrt))
			.map(i -> {
				return i < arr.length ? arr[i] : 0;
			})
			.toArray();
    }
}