import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int[] arr) {
        return Arrays.stream(arr)
			.flatMap(i -> IntStream.generate(() -> i).limit(i))
			.toArray();
    }
}