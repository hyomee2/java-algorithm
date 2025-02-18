import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static int time = 0, count = 0;
    static int[] isVisited = new int[100001]; 
    static int[] prev = new int[100001];

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs(N, K);

        // 이동 방법
        List<Integer> tracks = new ArrayList<>();
        
        for (int i = K; i != N; i = prev[i]) {
            tracks.add(i);
        }
        
        tracks.add(N);
        Collections.reverse(tracks); 
        
        // 시간
        sb.append(time).append('\n');
        
        for (int track : tracks) {
            sb.append(track).append(" ");
        }
       
        System.out.println(sb);
    }

    static void bfs(int n, int k) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] {n, 0});
        isVisited[n] = 1;

        while (!que.isEmpty()) {
            int[] subin = que.poll();

            if (subin[0] == k) {
                time = subin[1];
                return;
            }

            int[] movings = { -1, 1, subin[0] }; 

            for (int moving : movings) {
                int nextPos = subin[0] + moving;
                
                if (moving == subin[0]) { 
                    nextPos = subin[0] * 2;
                }

                if (nextPos >= 0 && nextPos <= 100000 && (isVisited[nextPos] == 0 || isVisited[nextPos] == subin[1] + 1)) {
                    isVisited[nextPos] = subin[1] + 1;
                    prev[nextPos] = subin[0];
                    que.add(new int[] {nextPos, subin[1] + 1});
                }
            }
        }
    }
}
