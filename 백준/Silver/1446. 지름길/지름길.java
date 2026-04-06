import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        List<int[]>[] graph = new ArrayList[10001];
        for (int i = 0; i < 10001; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            if (end > D || end - start <= distance) {
                continue;
            }

            graph[end].add(new int[]{start, distance});
        }

        int[] dist = new int[D + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        for (int i = 1; i <= D; i++) {
            dist[i] = dist[i - 1] + 1;

            for (int[] g : graph[i]) {
                if (dist[g[0]] != Integer.MAX_VALUE) {
                    dist[i] = Math.min(dist[i], dist[g[0]] + g[1]);
                }
            }
        }

        System.out.println(dist[D]);
    }
}