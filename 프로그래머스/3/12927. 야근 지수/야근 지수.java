import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b, a)
        );
        
        for (int w : works) {
            pq.offer(w);
        }
        
        while (n > 0 && !pq.isEmpty()) {
            Integer cur = pq.poll();
            if (cur < 1) {
                continue;
            }
            
            if (cur - 1 > 0) {
                pq.offer(--cur);
            }
            
            n--;
        }
        
        while (!pq.isEmpty()) {
            Integer cur = pq.poll();
            answer += (long) cur * cur;
        }
        
        return answer;
    }
}