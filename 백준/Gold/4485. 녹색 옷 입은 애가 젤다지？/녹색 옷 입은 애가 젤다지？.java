import java.io.*;
import java.util.*;

public class Main {
    static int[][] table;
    static int[][] minTable;
    static int[][] dxy = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int count = 0;

        while(true) {
            int N = Integer.parseInt(br.readLine());
            count++;

            if (N == 0) {
                break;
            }

            table = new int[N][N];
            minTable = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                for (int j = 0; j < N; j++) {
                    table[i][j] = Integer.parseInt(st.nextToken());
                    minTable[i][j] = Integer.MAX_VALUE;
                }
            }

            dijkstra();

            sb.append("Problem ").append(count).append(": ").append(minTable[N-1][N-1]).append("\n");
        }

        System.out.println(sb);
    }

    public static void dijkstra() {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[2] - b[2]  // cost 기준 정렬
        );

        pq.offer(new int[]{0, 0, table[0][0]});
        minTable[0][0] = table[0][0];

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[0];
            int y = cur[1];
            int cost = cur[2];

            if (cost > minTable[x][y]) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx =  x + dxy[i][0];
                int ny = y + dxy[i][1];

                if (!valid(nx, ny)) {
                    continue;
                }

                int temp = cost + table[nx][ny];

                if (temp < minTable[nx][ny]) {
                    minTable[nx][ny] = temp;
                    pq.offer(new int[]{nx, ny, temp});
                }
            }
        }
    }

    public static boolean valid(int x, int y) {
        return (x >= 0 && y >= 0 && x < table.length && y < table[x].length);
    }
}