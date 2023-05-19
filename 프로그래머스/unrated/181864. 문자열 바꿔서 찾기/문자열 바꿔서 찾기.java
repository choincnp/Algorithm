
class Solution {
    public int solution(String myString, String pat) {
        StringBuilder sb = new StringBuilder();
        myString.chars().mapToObj(c -> c=='A' ? "B" : "A").forEach(sb::append);
        return sb.indexOf(pat) == -1 ? 0 : 1;
    }
}