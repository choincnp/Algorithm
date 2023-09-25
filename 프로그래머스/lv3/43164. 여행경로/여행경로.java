import java.util.*;
class Solution {
    boolean[] visited;
    ArrayList<String> route;
    public String[] solution(String[][] tickets) {
        route = new ArrayList<>();
        visited = new boolean[tickets.length];
        DFS("ICN", "ICN", 0, tickets);
        Collections.sort(route);
        String[] answer = route.get(0).split(",");
        return answer;
    }
    void DFS(String start, String sum, int count, String[][] tickets){
        if (count == tickets.length){
            route.add(sum);
            return;
        }
        for (int i=0; i<tickets.length; i++){
            if (!visited[i] && start.equals(tickets[i][0])){
                visited[i] = true;
                DFS(tickets[i][1], sum+","+tickets[i][1], count+1, tickets);
                visited[i] = false;
            }
        }
    }
}