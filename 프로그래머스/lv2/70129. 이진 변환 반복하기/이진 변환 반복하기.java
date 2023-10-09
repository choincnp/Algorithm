class Solution {
    public int[] solution(String s) {
        int i=0;
        int count = 0;
        while (!s.equals("1")){
            i++;
            String ns = s.replace("0", "");
            count += s.length() - ns.length();
            s = Integer.toBinaryString(ns.length())+"";
        }
        return new int[]{i,count};
    }
}