import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
		Map<String, Integer> yearn = new HashMap<>();
		for (int i = 0; i < name.length; i++) {
			yearn.put(name[i], yearning[i]);
		}
		for (int i=0; i< photo.length; i++){
			int sum = 0;
			for (int j=0; j< photo[i].length; j++){
			    int found = yearn.get(photo[i][j]) == null ? 0 : yearn.get(photo[i][j]);
                sum += found;
			}
			answer[i] = sum;
		}
        return answer;
    }
}