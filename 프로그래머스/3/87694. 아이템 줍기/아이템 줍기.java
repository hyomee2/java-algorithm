import java.util.*;

class Solution {
    static int[][] map;
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        map = new int[101][101];
        
        // map 만들기 - 1로 채움
        for (int[] rect : rectangle) {
            for (int i = rect[0] * 2; i <= rect[2] * 2; i++) {
                for (int j = rect[1] * 2; j <= rect[3] * 2; j++) {
                    map[i][j] = 1;
                }
            }
        }
        
        // map 만들기 - 내부는 0으로 빈칸 표시
        for (int[] rect : rectangle) {
            for (int i = rect[0] * 2 + 1; i < rect[2] * 2; i++) {
                for (int j = rect[1] * 2 + 1; j < rect[3] * 2; j++) {
                    map[i][j] = 0;
                }
            }
        }
        
        return bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);
    }
    
    private int bfs(int startX, int startY, int itemX, int itemY) {
        Deque<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[101][101];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};
        
        queue.offer(new int[]{startX, startY, 0});
        visited[startX][startY] = true;
        
        while(!queue.isEmpty()) {
            int[] location = queue.poll();
            
            if (location[0] == itemX && location[1] == itemY) {
                return location[2] / 2;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = location[0] + dx[i];
                int ny = location[1] + dy[i];
                
                if (nx >= 0 && nx <= 100 && ny >= 0 && ny <= 100 && map[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new int[] {nx, ny, location[2] + 1});
                }
            }
        }
        
        return -1;
    }
}