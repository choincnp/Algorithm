import java.util.stream.*;
import java.util.*;
class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        return IntStream.range(0, rank.length)
			.filter(i -> attendance[i])
			.boxed()
			.sorted(Comparator.comparing(i -> rank[i]))
			.limit(3)
			.reduce((current, next) -> current*100 + next)
			.get();
    }
}