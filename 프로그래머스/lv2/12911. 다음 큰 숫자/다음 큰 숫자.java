class Solution {
    public int solution(int n) {
        int count = Integer.toBinaryString(n++).replace("0", "").length();
        while (true){
            if(Integer.toBinaryString(n++).replace("0","").length() == count){
                break;
            }
        }
        return n-1;
    }
}