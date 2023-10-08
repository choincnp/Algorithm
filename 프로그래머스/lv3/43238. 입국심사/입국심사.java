class Solution {
    public long solution(int n, int[] times) {
        long start = 0;
        long end = 1000000000000000001l;
        long answer = 0;
        while (start <= end){
            long mid = (start + end) / 2;
            long count = 0;
            for (int i=0; i<times.length; i++){
                count += mid / times[i];
                if (count > n) break;
            }
            if (count >= n){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            answer = Math.min(end, mid);
        }
        return answer+1;
    }
}