class Solution {
    public String solution(String s, int n) {
        String answer = "";
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)==' '){answer += ' ';}
            else answer += kaiser(s.charAt(i),n);
        }
        return answer;
    }
    static char kaiser(char lang, int n){
        int k = (int)(lang+n);
        if ((int)lang >= 97){ // 소문자
            if(k>122) return (char)(k-26);
            else return (char)k;
        }
        else{
            if (k>90) return (char)(k-26);
            else return (char)k;
        }
        
    }
}