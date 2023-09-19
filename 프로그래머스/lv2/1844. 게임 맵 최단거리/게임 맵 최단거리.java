import java.util.*;
class Solution {
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};
    int R, C;
    boolean[][] visited;
    public int solution(int[][] maps) {
        R = maps.length;
        C = maps[0].length;
        visited = new boolean[R][C];
        BFS(maps);
        return maps[R-1][C-1] > 1 ? maps[R-1][C-1] : -1;
    }
    void BFS(int[][] maps){
        Queue<int[]> queue = new LinkedList();
        queue.add(new int[]{0,0});
        visited[0][0] = true;
        while (!queue.isEmpty()){
            int[] point = queue.poll();
            for (int i=0; i<4; i++){
                int nx = point[0] + dx[i];
                int ny = point[1] + dy[i];
                if (nx >= 0 && ny >= 0 && nx < R && ny < C){
                    if (maps[nx][ny] == 1 && !visited[nx][ny]){
                        visited[nx][ny] = true;
                        maps[nx][ny] = maps[point[0]][point[1]] + 1;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}