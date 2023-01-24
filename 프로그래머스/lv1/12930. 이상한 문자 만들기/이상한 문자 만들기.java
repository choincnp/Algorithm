class Solution {
    public String solution(String s) {
        String answer = "";
        s += "1";
        String[] sArr = s.split(" ");
        for (int i=0; i<sArr.length; i++){
            for (int j=0; j<sArr[i].length(); j++){
                if (sArr[i].charAt(j)==' ') answer += " ";
                else if (sArr[i].charAt(j)=='1');
                else if (j%2==0) answer += sArr[i].substring(j,j+1).toUpperCase();
                else answer += sArr[i].substring(j,j+1).toLowerCase();
            }
            if (i<sArr.length-1) answer += " ";
        }
        return answer;
    }
}