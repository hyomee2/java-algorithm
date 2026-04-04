import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());  // 도시 개수
        int M = Integer.parseInt(st.nextToken());  // 도로 개수
        int K = Integer.parseInt(st.nextToken());  // 최단 거리 정보
        int X = Integer.parseInt(st.nextToken());  // 출발 도시 번호

        List<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
        }

        int[] dist = new int[N + 1];
        Arrays.fill(dist, -1);
        dist[X] = 0;

        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(X);

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            if (dist[cur] >= K) {
                continue;
            }

            for (int newNode : graph[cur]) {
                if (dist[newNode] == -1) {
                    dist[newNode] = dist[cur] + 1;
                    queue.offer(newNode);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (dist[i] == K) {
                sb.append(i).append("\n");
            }
        }

        if (sb.length() == 0) {
            sb.append(-1).append("\n");
        }

        System.out.println(sb);
    }
}
