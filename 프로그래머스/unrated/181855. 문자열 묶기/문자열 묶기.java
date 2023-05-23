import java.util.*;
class Solution {
    public int solution(String[] strArr) {
        int[] answer = new int[strArr.length];
		for (int i=0; i<strArr.length; i++){
			answer[strArr[i].length()]++;
		}
		int max = 0;
        for (int i=0; i<answer.length; i++){
            if (answer[i] > max) max = answer[i];
        }
        return max;
    }
}