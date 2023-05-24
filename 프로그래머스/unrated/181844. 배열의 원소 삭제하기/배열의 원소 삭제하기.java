import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        return Arrays.stream(arr)
			.filter(i -> Arrays.stream(delete_list).noneMatch(j -> j == i))
			.toArray();
    }
}