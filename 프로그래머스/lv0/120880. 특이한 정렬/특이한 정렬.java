import java.util.*;
class Solution {
    public ArrayList solution(int[] numlist, int n) {
        ArrayList<Integer> num = new ArrayList<>();
        Arrays.sort(numlist);
        for (int i : numlist) num.add(i);
        num.sort((o1,o2)-> Integer.compare(Math.abs(o2 - n), Math.abs(o1 - n)));
        Collections.reverse(num);
        return num;
    }
}