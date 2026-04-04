import java.io.*;
import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int V = Integer.parseInt(st.nextToken());  // 정점 수
        int E = Integer.parseInt(st.nextToken());  // 간선 수

        int K = Integer.parseInt(br.readLine());  // 시작 정점 번호

        List<int[]>[] graph = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        // 그래프 입력
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new int[] {v, w});
        }

        int[] dist = new int[V + 1];
        Arrays.fill(dist, INF);

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[1] - b[1]
        );

        // 시작점 -> 시작점은 거리 0이므로
        dist[K] = 0;
        pq.add(new int[]{K, 0});

        while (!pq.isEmpty()) {
            int[] now = pq.poll();

            int cur = now[0];
            int cost = now[1];

            if (dist[cur] < cost) {
                continue;
            }

            // 연결된 노드들 확인
            for (int[] next : graph[cur]) {
                int nextNode = next[0];
                int nextCost = cost + next[1];

                if (dist[nextNode] > nextCost) {
                    dist[nextNode] = nextCost;
                    pq.add(new int[]{nextNode, nextCost});
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF) {
                sb.append("INF");
            } else {
                sb.append(dist[i]);
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}