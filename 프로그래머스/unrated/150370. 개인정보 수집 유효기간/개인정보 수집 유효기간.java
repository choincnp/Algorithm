import java.util.*;
class Solution {
    public ArrayList solution(String today, String[] terms, String[] privacies) {
        String[] todayArr = today.split("[.]");
        String[][] privaciesArr = new String[privacies.length][];
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, String> termsMap = new HashMap<>();
        for (String s : terms)
            termsMap.put(s.charAt(0)+"", s.split(" ")[1]);
        for (int i=0; i<privacies.length; i++){
            privaciesArr[i] = privacies[i].split(" ");
            String date[] = privaciesArr[i][0].split("[.]");
            int year = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int day = Integer.parseInt(date[2]);
            int addMonth = Integer.parseInt(termsMap.get(privaciesArr[i][1]));
            month += addMonth;
            if (month > 12){
                year += month / 12;
                month %= 12;
                if (month == 0){
                    year -= 1;
                    month = 12;
                }
            }
            day -= 1;
            if (day == 0){
                month -= 1;
                day = 28;
                if (month == 0){
                    year -= 1;
                    month = 12;
                }
            }
            System.out.println(year+"."+month+"."+day); // 평가기준 문제
            if (year < Integer.parseInt(todayArr[0])) answer.add(i+1);
            else if (year == Integer.parseInt(todayArr[0])){
                if (month < Integer.parseInt(todayArr[1])) answer.add(i+1);
                else if (month == Integer.parseInt(todayArr[1])){
                    if (day<Integer.parseInt(todayArr[2])) answer.add(i+1);
                }
            };
        }
        return answer;
    }
}