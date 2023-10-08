class Solution {
    static int count;
    public int solution(int n) {
        for (int i=1; i<=n; i++){
            DFS(i, i, n);
        }
        return count;
    }
    void DFS(int x, int now, int dest){
        if (now == dest){
            count++;
            return;
        }
        if (x <= dest && now <= dest){
            DFS(x+1, now+x+1, dest);
        }
    }
}