import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, computers, visited);
                count++;
            }
        }
        

        return count;
    }
    
    public static void dfs(int n, int[][] computers, boolean[] visited) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(n);
        visited[n] = true;
        
        while(!stack.isEmpty()) {
            int num = stack.pop();
            
            for (int i = 0; i < computers[num].length; i++) {
                if (computers[num][i] == 1 && !visited[i]) {  // 본인인것은 체크 안해도 됨. 이미 visited로 돼있을테니
                    stack.push(i);
                    visited[i] = true;
                }
            }
        }
    }
}