class Solution {
    public int solution(String myString, String pat) {
        return myString.toLowerCase().indexOf(pat.toLowerCase()) == -1 ? 0 : 1;
    }
}