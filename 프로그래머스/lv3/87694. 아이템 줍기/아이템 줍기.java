import java.util.*;
class Solution {
    Queue<int[]> queue = new LinkedList<>();
    int[][] field = new int[101][101];
    boolean[][] visited = new boolean[101][101];
    int count;
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};
    int x1, x2, y1, y2;
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        for(int i=0; i<rectangle.length; i++){
            fill(2*rectangle[i][0], 2*rectangle[i][1], 2*rectangle[i][2], 2*rectangle[i][3]);
        }
        queue.offer(new int[]{2*characterX, 2*characterY, 0});
        // for (int[] square : rectangle){
        //     x1 = square[0];
        //     y1 = square[1];
        //     x2 = square[2];
        //     y2 = square[3];
        //     queue.offer(new int[]{characterX, characterY, 0});
        //     visited[x1][y1] = true;
        //     for (int i=x1; i<=x2; i++){
        //         for (int j=y1; j<=y2; j++){
        //             field[i][y1] = 1;
        //             field[i][y2] = 1;
        //             field[x1][j] = 1;
        //             field[x2][j] = 1;
        //         }
        //     }
        // }
        return BFS(field, 2*itemX, 2*itemY)/2;
    }
    int BFS(int[][] field, int itemX, int itemY){
        while (!queue.isEmpty()){
            int[] point = queue.poll();
            if (point[0] == itemX && point[1] == itemY){
                return point[2];
            }
            for (int i=0; i<4; i++){
                int nx = point[0] + dx[i];
                int ny = point[1] + dy[i];
                if (nx >= 0 && ny >= 0 && nx < 101 && ny<101){
                    if (!visited[nx][ny] && field[nx][ny] == 1){
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny, point[2]+1});
                    }
                }
            }
        }
        return 1;
    }

    void fill(int x1, int y1, int x2, int y2){
        for(int i=x1; i<=x2; i++){
            for(int j=y1; j<=y2; j++){
                if(field[i][j]==2) continue;
                field[i][j]=2;
                if(i==x1||i==x2||j==y1||j==y2){
                    field[i][j]=1;
                }
            }
        }
    }
}