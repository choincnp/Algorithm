import java.util.*;
import java.util.Iterator;
class Solution {
    public String solution(int a, int b) {
        String answer = "";
        int[] month = {31,29,31,30,31,30,31,31,30,31,30,31};
        String[] date = {"FRI","SAT","SUN","MON","TUE","WED","THU"};
        int total = 0;
        
        for (int i=0; i<a-1; i++){
            total += month[i];
        }
        total = total + b-1;
        answer = date[total%7];
        return answer;
    }
}