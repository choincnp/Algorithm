class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];
		my_string.chars().forEach(
			c -> {
				if ('a'<= c && c <= 'z') {
					answer[c-'a'+26]++;
				} else {
					answer[c-'A']++;
				}
			}
		);
		return answer;
    }
}