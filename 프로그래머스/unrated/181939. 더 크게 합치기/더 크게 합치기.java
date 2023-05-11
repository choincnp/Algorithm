class Solution {
    public int solution(int a, int b) {
        StringBuilder sb = new StringBuilder();
        int c = Integer.parseInt(sb.append(a).append(b).toString());
        sb = new StringBuilder();
        int d = Integer.parseInt(sb.append(b).append(a).toString());
        return c>d? c : d;
    }
}