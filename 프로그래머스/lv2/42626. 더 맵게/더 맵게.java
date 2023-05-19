import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        for (int i : scoville) pQueue.add(i);
        int count = 0;
		while (pQueue.peek() < K){
			if (pQueue.size() == 1){
				count = -1;
				break;
			} else if (pQueue.peek() < K){
				int first = pQueue.poll();
				int second = pQueue.poll();
				int newScoville = first + (second * 2);
				pQueue.add(newScoville);
				count++;
			}
		}
        return count;
    }
}