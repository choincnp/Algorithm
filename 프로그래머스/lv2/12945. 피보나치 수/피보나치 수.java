import java.util.stream.*;
class Solution {
    public int solution(int n) {
        int[] answer = new int[n+1];
		IntStream.rangeClosed(0,n)
			.forEach(i -> {
				if (i == 0) answer[i] = 0;
				else if (i == 1) answer[i] = 1;
				else answer[i] = (answer[i-1] + answer[i-2])%1234567;
			});
		return answer[n];
    }
}