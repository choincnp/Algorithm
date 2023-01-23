class Solution {
    boolean solution(String s) {
        boolean answer = true;
        s = s.toLowerCase();
        int[] answerArr = new int[2];
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)==('p')) answerArr[0]++;
            else if (s.charAt(i)==('y')) answerArr[1]++;
        }

        return (answerArr[0]==answerArr[1]? true : false);
    }
}