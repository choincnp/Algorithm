import java.util.stream.*;
class Solution {
    public int solution(String myString, String pat) {
        return (int)IntStream
            .range(0, myString.length()-pat.length()+1)
            .mapToObj(i -> myString.substring(i,i+pat.length()))
            .filter(s -> s.equals(pat))
            .count();
    }
}