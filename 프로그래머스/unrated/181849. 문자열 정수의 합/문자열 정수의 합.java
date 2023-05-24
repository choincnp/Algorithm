import java.util.stream.*;
class Solution {
    public int solution(String num_str) {
        return IntStream.range(0, num_str.length())
			.map(i -> Integer.parseInt(num_str.substring(i, i + 1)))
			.sum();
    }
}