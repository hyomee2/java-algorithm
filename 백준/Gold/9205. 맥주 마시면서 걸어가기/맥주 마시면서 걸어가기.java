import java.io.*;
import java.util.*;

public class Main {
    static Deque<Integer> queue;
    static boolean[] visited;
    static int n;
    static int[][] loc;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 배열로 상황 만들기
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine()); // 맥주 파는 편의점 수
            visited = new boolean[n + 2];
            loc = new int[n + 2][2];

            // loc 만들기
            for (int j = 0; j < n + 2; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                loc[j] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            }

            String answer = bfs() ? "happy" : "sad";
            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }

    public static boolean bfs() {
        queue = new ArrayDeque<>();
        visited[0] = true;
        queue.offer(0);

        while (!queue.isEmpty()) {
            int newIndex = queue.poll();

            if (newIndex == n + 1) {
                return true;
            }

            for (int i = 1; i < n + 2; i++) {
                if (!visited[i]) {
                    int distance = Math.abs(loc[newIndex][0] - loc[i][0]) + Math.abs(loc[newIndex][1] - loc[i][1]);

                    if (distance <= 1000) {
                        visited[i] = true;
                        queue.offer(i);
                    }
                }
            }
        }

        return false;
    }
}