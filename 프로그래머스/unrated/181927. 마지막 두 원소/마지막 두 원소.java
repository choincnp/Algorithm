import java.util.*;
class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length+1];
        for (int i=0; i<num_list.length; i++){
            if (i==num_list.length-1) {
             answer[i] = num_list[i];
             answer[i+1] = (num_list[i] > num_list[i-1]) ? num_list[i] - num_list[i-1] : 2 * num_list[i];
            }
            else answer[i] = num_list[i];
        }
        
        return answer;
    }
}