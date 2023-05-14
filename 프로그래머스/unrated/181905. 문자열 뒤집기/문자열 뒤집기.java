class Solution {
    public String solution(String my_string, int s, int e) {
        StringBuilder sb = new StringBuilder();
        String prefix = my_string.substring(0,s);
        String suffix = my_string.substring(e+1);
        return prefix+sb.append(my_string.substring(s,e+1)).reverse().toString()+suffix;
    }
}