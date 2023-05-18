import java.util.stream.*;
class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        return IntStream
			.rangeClosed(0, todo_list.length-1)
			.filter(i -> !finished[i])
			.mapToObj(i -> todo_list[i])
			.toArray(String[]::new);
    }
}