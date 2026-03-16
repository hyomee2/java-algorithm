import java.util.*;

class Solution {
    boolean[] used;
    boolean done = false;
    List<String> result = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        // 목적지 기준 알파벳순 정렬
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));
        used = new boolean[tickets.length];
        
        result.add("ICN");
        dfs("ICN", 0, tickets);
        
        return result.toArray(new String[0]);
    }
    
    private void dfs(String current, int count, String[][] tickets) {
        // 모든 티켓 다 사용한 경우
        if (count == tickets.length) {
            done = true;
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            // 아직 안 쓴 티켓인데 출발지가 현재 공항과 같은 경우
            if (!used[i] && tickets[i][0].equals(current)) {
                used[i] = true;
                result.add(tickets[i][1]);
                
                dfs(tickets[i][1], count + 1, tickets);
                
                if (done) {
                    return;
                }
                
                // 잘못된 길이었을 경우 백트래킹
                used[i] = false;
                result.remove(result.size() - 1);
            }
        }
    }
}