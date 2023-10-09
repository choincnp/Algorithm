import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[]{0,0};
        Map<String, Integer> map = new HashMap<>();
        map.put(words[0], 1);
        for (int i=1; i<words.length; i++){
            String oldWord = words[i-1];
            String newWord = words[i];
            map.put(newWord, map.getOrDefault(newWord, 0)+1);
            if (oldWord.charAt(oldWord.length()-1) != newWord.charAt(0) || map.get(newWord) == 2){
                return new int[]{i%n + 1, i/n + 1};
            }
        }
        return answer;
    }
}