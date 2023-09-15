import java.util.*;
class Solution {
    static ArrayList<Integer>[] comp;
    static boolean[] visited;
    static int count;
    public int solution(int n, int[][] computers) {
        comp = new ArrayList[n];
        visited = new boolean[n];
        for (int i=0; i<n; i++){
            comp[i] = new ArrayList<>();
        }
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if (i!=j && computers[i][j] == 1){
                    comp[i].add(j);
                    comp[j].add(i);
                }
            }
        }
        //DFS
        for (int i=0; i<n; i++){
            if (!visited[i]){
                count++;
                DFS(i);
            }
        }
        return count;
    }
    static void DFS(int n){
        visited[n] = true;
        for (int i : comp[n]){
            if (!visited[i]){
                DFS(i);
            }
        }
    }
    
}