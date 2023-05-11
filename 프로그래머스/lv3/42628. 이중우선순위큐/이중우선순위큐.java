import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(); // 작을수록 우선순위 높다
        PriorityQueue<Integer> mpQueue = new PriorityQueue<>(Collections.reverseOrder()); // 클수록 우선순위 높다
        for (int i=0; i<operations.length; i++){
            String[] command = operations[i].split(" ");
            if (pQueue.size() < 1 && command[0].equals("D"));
            else if (command[0].equals("I")){
                pQueue.add(Integer.parseInt(command[1]));
                mpQueue.add(Integer.parseInt(command[1]));
            } else{
                if(Integer.parseInt(command[1]) < 0) {
                int min = pQueue.poll();
                mpQueue.remove(min);
                continue;
            }
            int max = mpQueue.poll();
            pQueue.remove(max);
            }
        }
        if (!pQueue.isEmpty()) {
            answer[0] = mpQueue.poll();
            answer[1] = pQueue.poll();
        }
        return answer;
    }
}