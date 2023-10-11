import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<tangerine.length; i++){
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0)+1);
        }
        for (Map.Entry<Integer, Integer> set : map.entrySet()) {
			pQueue.add(set.getValue());
		}
        int answer = 0;
        int sum = 0;
        while (true){
            int count = pQueue.poll();
            sum += count;
            answer++;
            if (sum >= k) break;
        }
        return answer;
    }
}