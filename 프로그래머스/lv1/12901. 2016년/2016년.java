import java.util.*;
import java.util.Iterator;
class Solution {
    public String solution(int a, int b) {
        String answer = "";
        Map<Integer, Integer> month = new TreeMap<>();
        Map<Integer, String> day = new TreeMap<>();
        month.put(0,31);
        month.put(1,29);
        month.put(2,31);
        month.put(3,30);
        month.put(4,31);
        month.put(5,30);
        month.put(6,31);
        month.put(7,31);
        month.put(8,30);
        month.put(9,31);
        month.put(10,30);
        day.put(1,"FRI");
        day.put(2,"SAT");
        day.put(3,"SUN");
        day.put(4,"MON");
        day.put(5,"TUE");
        day.put(6,"WED");
        day.put(0,"THU");
        Iterator<Integer> it = month.keySet().iterator();
        a -= 1;
        int i=0;
        while (it.hasNext()){
            if (it.next() < a) b += month.get(i);
            else break;
            i++;
        }
        answer = day.get(b%7);
        return answer;
    }
}