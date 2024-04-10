import java.util.*;
class Solution {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        Queue<Work> queue = new LinkedList<>();
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i=0; i<progresses.length; i++){
            queue.offer(new Work(progresses[i], speeds[i]));
        }
        int day = 1;
        while (!queue.isEmpty()){
            Work now = queue.peek();
            int progress = now.progress;
            int speed = now.speed;
            if (progress + (day * speed) >= 100){
                queue.poll();
                int count = 1;
                while (queue.size() >= 1){
                    Work next = queue.peek();
                    progress = next.progress;
                    speed = next.speed;
                    if (progress + (day * speed) >= 100){
                        queue.poll();
                        count++;
                    } else break;
                }
                answer.add(count);
            }
            day++;
        }
        return answer;
    }
    static class Work{
        int progress;
        int speed;
        public Work(int progress, int speed){
            this.progress = progress;
            this.speed = speed;
        }
    }
}