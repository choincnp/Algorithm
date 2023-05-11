class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        boolean flag = false;
        while (true){
            if (ineq.equals(">")&&eq.equals("=")&&(n>=m)){
                flag = true;
                break;
            }
            else if (ineq.equals("<")&&eq.equals("=")&&(n<=m)){
                flag = true;
                break;
            }
            else if (ineq.equals(">")&&eq.equals("!")&&(n>m)){
                flag = true;
                break;
            }
            else if (ineq.equals("<")&&eq.equals("!")&&(n<m)) {
                flag = true;
                break;
            }
            else break;
        }
        return flag ? 1 : 0;
    }
}