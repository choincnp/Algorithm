import java.util.*;
class Solution {
    public int[] solution(String myString) {
        if (myString.charAt(myString.length()-1)=='x') myString = myString.concat(" ");
        return Arrays.stream(myString.split("x"))
            .mapToInt(s -> s.equals(" ") ? 0 : s.length())
            .toArray();
    }
}