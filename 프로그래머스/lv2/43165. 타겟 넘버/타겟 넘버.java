class Solution {
    int answer;
    int length;
    public int solution(int[] numbers, int target) {
        length = numbers.length;
        DFS(0, 0, target, numbers);
        return answer;
    }
    void DFS(int idx, int sum, int target, int[] numbers){
        if (idx == length){
            if (sum == target){
                answer++;
            }
            return;
        }
        DFS(idx+1, sum + numbers[idx], target, numbers);
        DFS(idx+1, sum - numbers[idx], target, numbers);
    }
}