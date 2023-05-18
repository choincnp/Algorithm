import java.util.stream.*;
class Solution {
    public String[] solution(String[] strArr) {
        IntStream
			.rangeClosed(0, strArr.length-1)
			.forEach(i -> {
				if (i%2 == 0) strArr[i] = strArr[i].toLowerCase();
				else strArr[i] = strArr[i].toUpperCase();
			});
        return strArr;
    }
}