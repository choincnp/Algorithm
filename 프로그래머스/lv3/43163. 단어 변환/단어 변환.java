import java.util.*;
class Solution {
    Queue<Word> queue = new LinkedList<>();
    boolean[] visited;
    int answer = 51;
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        queue.offer(new Word(begin, 0));
        BFS(target, words);
        return answer == 51 ? 0 : answer+1;
    }
    public void BFS(String target, String[] words){
        while (!queue.isEmpty()){
            Word cur = queue.poll();
            for (int i=0; i<words.length; i++){
                if(!visited[i] && check(cur.word, words[i])){
                    if (words[i].equals(target)){
                        answer = Math.min(answer, cur.count);
                    }
                    visited[i] = true;
                    queue.offer(new Word(words[i], cur.count+1));
                }
            }
        }
    }
    boolean check(String str1, String str2){
        int count = 0;
        for (int i=0; i<str1.length(); i++){
            if (str1.charAt(i) != str2.charAt(i)){
                count++;
            }
            if (count > 1){
                return false;
            }
        }
        return true;
    }
    class Word{
        String word;
        int count;
        public Word(String word, int count){
            this.word = word;
            this.count = count;
        }
    }
}