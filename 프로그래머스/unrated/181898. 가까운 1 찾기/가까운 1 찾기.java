class Solution {
    public int solution(int[] arr, int idx) {
        int answer = -1;
        while (arr.length > idx){
            if (arr[idx] == 1) {
                answer = idx;
                break;
            }
            idx++;
        }
        return answer;
    }
}