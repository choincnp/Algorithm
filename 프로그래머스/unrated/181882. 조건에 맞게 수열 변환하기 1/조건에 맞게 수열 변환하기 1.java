import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        return Arrays.stream(arr)
			.mapToObj(i -> {
				if (i >= 50 && i %2 == 0) return i/2;
				else if (i < 50 && i % 2 == 1) return i*2;
				else return i;
			})
			.mapToInt(Integer::intValue)
			.toArray();
    }
}