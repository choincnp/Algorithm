import java.util.*;
class Solution {
    public int solution(int[] num_list) {
        return num_list.length >= 11 ? 
            Arrays.stream(num_list)
				.reduce(0, (a, b) -> a + b):
			Arrays.stream(num_list)
				.reduce(1, (a, b) -> a * b);
    }
}