class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        for (int i : numbers)
            answer += i;
        return 45-answer;
    }
}