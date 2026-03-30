import java.util.*;

class Solution {
    static char[] characters = {'A', 'E', 'I', 'O', 'U'};
    
    public int solution(String word) {
        Deque<String> stack = new ArrayDeque<>();
        
        for (int i = 4; i >= 0; i--) {
            stack.push(String.valueOf(characters[i]));
        }
        
        int count = 0;

        while (!stack.isEmpty()) {
            String current = stack.pop();
            count++;
            
            if (current.equals(word)) {
                return count;
            }
            
            if (current.length() < 5) {
                for (int i = 4; i >= 0; i--) {
                    stack.push(current + characters[i]);
                }
            }
        }
        
        return count;
    }
    
}