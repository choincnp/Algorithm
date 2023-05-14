import java.util.*;
class Solution {
    public String[] solution(String my_string) {
        String[] array = new String[my_string.length()];
        for (int i=0; i<my_string.length(); i++){
            array[i] = my_string.substring(i);
        }
        Arrays.sort(array);
        return array;
    }
}