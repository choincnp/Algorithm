import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
		int start = -1;
		int end = -1;
        int count = 0;
		for (int i=0; i<arr.length; i++){
			if (arr[i] == 2){
                count++;
                if (start == -1) start = i;
                else end = i;
            }
		}
		if (start == -1) return new int[]{-1};
        else if (count == 1) return new int[]{2}; 
		else {
			for (int i=start; i<=end; i++){
				list.add(arr[i]);
			}
			return list.stream().mapToInt(i->i).toArray();
		}
    }
}