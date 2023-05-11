class Solution {
    public int solution(int a, int b) {
        StringBuilder sb = new StringBuilder();
        int c = Integer.parseInt(sb.append(a).append(b).toString());
        int d = 2*a*b;
        return Math.max(c,d);
    }
}