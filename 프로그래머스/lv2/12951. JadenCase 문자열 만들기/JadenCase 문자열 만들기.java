class Solution {
    public String solution(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        boolean empty = false;
        sb.append(Character.toUpperCase(s.charAt(0)));
        for (int i=1; i<s.length(); i++){
            if (s.charAt(i) == ' '){
                empty = true;
                sb.append(s.charAt(i));
            } else {
                if (empty) {
                    sb.append(Character.toUpperCase(s.charAt(i)));
                    empty = false;
                } else {
                    sb.append(s.charAt(i));
                }
            }
        }
        return sb.toString();
    }
}