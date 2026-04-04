import java.io.*;
import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  // 도시 개수
        int M = Integer.parseInt(br.readLine());  // 버스 개수

        StringTokenizer st;

        // graph 초기화
        List<int[]>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());  // 출발점
            int v = Integer.parseInt(st.nextToken());  // 도착점
            int w = Integer.parseInt(st.nextToken());  // 비용
            graph[u].add(new int[] {v, w});
        }

        st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());  // 출발 도시
        int end = Integer.parseInt(st.nextToken());  // 도착 도시

        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[1] - b[1]
        );

        dist[start] = 0;
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int city = cur[0];
            int cost = cur[1];

            if (dist[city] < cost) {
                continue;
            }

            for (int[] next : graph[city]) {
                int nextCity = next[0];
                int totalCost = cost + next[1];

                if (dist[nextCity] > totalCost) {
                    dist[nextCity] = totalCost;
                    pq.add(new int[]{nextCity, totalCost});
                }
            }
        }

        System.out.println(dist[end]);
    }
}