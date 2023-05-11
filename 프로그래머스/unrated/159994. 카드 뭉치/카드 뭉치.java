import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> queueOne = new LinkedList<>();
        Queue<String> queueTwo = new LinkedList<>();
        Queue<String> queueTarget = new LinkedList<>();
        for (int i=0; i<cards1.length; i++){
            queueOne.add(cards1[i]);
        }
        for (int i=0; i<cards2.length; i++){
            queueTwo.add(cards2[i]);
        }
        for (int i=0; i<goal.length; i++){
            queueTarget.add(goal[i]);
        }
        while (queueTarget.size() != 0){
            if (queueOne.size()!=0 && queueOne.peek().equals(queueTarget.peek())){
                queueOne.poll();
                queueTarget.poll();
            } 
            else if (queueTwo.size()!=0 && queueTwo.peek().equals(queueTarget.peek())){
                queueTwo.poll();
                queueTarget.poll();
            }
            else return "No";
        }
        return "Yes";
    }
}