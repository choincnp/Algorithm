import java.util.*;
class Solution {
    public ArrayList solution(int[] answers) {
        int[] answer = new int[3];
        ArrayList<Integer> rank = new ArrayList<>();
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {2,1,2,3,2,4,2,5};
        int[] arr3 = {3,3,1,1,2,2,4,4,5,5};
        for (int i=0; i<answers.length; i++){
            if (answers[i]==arr1[i%5]) answer[0]++;
            if (answers[i]==arr2[i%8]) answer[1]++;
            if (answers[i]==arr3[i%10]) answer[2]++;
        }
        int max = Math.max(answer[0], Math.max(answer[1], answer[2]));
        for (int i=0; i<3 ; i++){
            if (max==answer[i]) rank.add(i+1);
            else if (max<answer[i]){
                rank.clear();
                rank.add(i+1);
            }
        }
        return rank;
    }
}