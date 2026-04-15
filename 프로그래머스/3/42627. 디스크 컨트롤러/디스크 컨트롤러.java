import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        // 요청 시간 기준 정렬
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        // 값 순서: 요청시각, 작업소요시간
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) 
                return a[1] - b[1];
            return a[0] - b[0];
        });
        
        int i = 0; // 현재 인덱스
        int time = 0;
        
        // 아직 도착 안한 작업이 있거나 큐에 들어가 있는 작업이 있는 경우
        while (i < jobs.length || !pq.isEmpty()) {
            // 아직 도착 안한 작업이 있고, 그 작업의 요청 시각이 현재 시각 이전이라면
            if (i < jobs.length && jobs[i][0] <= time) {
                pq.offer(jobs[i]);
                i++;
                continue;
            }
            
            if (!pq.isEmpty()) {
                int[] current = pq.poll();
                time += current[1];
                answer += (time - current[0]);
            } else {
                time = jobs[i][0];
            }
        }
        
        return answer / jobs.length;
    }
}