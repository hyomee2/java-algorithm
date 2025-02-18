import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static int time = 0, count = 0;
    static int[] isVisited = new int[100001]; 

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs(N, K);

        sb.append(time).append('\n');
        sb.append(count);

        System.out.println(sb);
    }

    static void bfs(int n, int k) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] {n, 0});
        isVisited[n] = 1;

        while (!que.isEmpty()) {
            int[] subin = que.poll();

            if (subin[0] == k) {
                if (count == 0) {
                    time = subin[1]; 
                }
                count++;
                continue; 
            }

            int[] movings = { -1, 1, subin[0] }; 

            for (int moving : movings) {
                int nextPos = subin[0] + moving;
                
                if (moving == subin[0]) { 
                    nextPos = subin[0] * 2;
                }

                if (nextPos >= 0 && nextPos <= 100000 && (isVisited[nextPos] == 0 || isVisited[nextPos] == subin[1] + 1)) {
                    isVisited[nextPos] = subin[1] + 1;
                    que.add(new int[] {nextPos, subin[1] + 1});
                }
            }
        }
    }
}
