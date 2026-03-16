import java.util.*;

class Solution {
    static int[][] dxy = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
    static boolean[][] visited;
    
    public int solution(int[][] maps) {
        return bfs(maps);
    }
    
    public static int bfs(int[][] maps) {
        int mR = maps.length;
        int mC = maps[0].length;
        
        visited = new boolean[mR][mC];
        
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {0, 0, 1});
        visited[0][0] = true;
        
        while(!queue.isEmpty()) {
            int[] location = queue.poll();
            int r = location[0];
            int c = location[1];
            int count = location[2];
            
            if (r == mR - 1 && c == mC - 1) {
                return count;
            }
            
            for (int i = 0; i < 4; i++) {
                int nR = r + dxy[i][0];
                int nC = c + dxy[i][1];
                if (movable(maps, nR, nC)) {
                    visited[nR][nC] = true;
                    queue.offer(new int[] {nR, nC, count + 1});
                }
            }
        } 
        
        return -1;
    }
    
    public static boolean movable(int[][] maps, int r, int c) {
        return (r >= 0 && r < maps.length && c >= 0 && c < maps[0].length && !visited[r][c] && maps[r][c] == 1);
    }
}