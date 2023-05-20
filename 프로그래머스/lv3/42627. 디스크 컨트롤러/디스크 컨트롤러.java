import java.util.*;
class Solution {
    /*
     * readyQueue와 waitingQueue를 생각해야 한다.
     * 각 시점에 실행할 수 있는 스케쥴 중에 가장 빨리 끝나는 작업을 선택한다.
     */
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];// 요청시간 기준 정렬
			}
		});
		PriorityQueue<int[]> pQueue = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1]; // 소요시간 기준 정렬
			}
		});

		pQueue.add(jobs[0]); // queue의 가장 빠른 요청시간을 가진 작업을 먼저 넣어준다.
		int time = jobs[0][0];
		int sum = 0;
		int index = 1;
		while (!pQueue.isEmpty()){
			int[] job = pQueue.poll();
			time += job[1];
			sum += time - job[0];
			while (index < jobs.length && jobs[index][0] <= time) {
				pQueue.add(jobs[index++]);
			}
            // ReadyQueue는 비어있고 waitingQueue는 비어있지 않은 경우
			if (index < jobs.length && pQueue.isEmpty()) { 
				time = jobs[index][0];
				pQueue.add(jobs[index++]);
			}
		}
		return sum / jobs.length;
    }
}