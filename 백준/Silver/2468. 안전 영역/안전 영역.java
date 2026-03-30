import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static Deque<int[]> stack = new ArrayDeque<>();
    static boolean[][] visited;
    static int[][] table;
    static int N, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        table = new int[N][N];
        StringTokenizer st;
        int maxHeight = 0;
        int safe = 1;

        // 테이블 만들기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, table[i][j]);
            }
        }

        for (int h = 1; h < maxHeight; h++) {
            visited = new boolean[N][N];
            count = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (table[i][j] > h && !visited[i][j]) {
                        dfs(i, j, h);
                        count++;
                    }
                }
            }

            safe = Math.max(safe, count);
        }

        System.out.println(safe);
    }

    public static void dfs(int x, int y, int h) {
        stack.push(new int[]{x, y});
        visited[x][y] = true;

        while (!stack.isEmpty()) {
            int[] current = stack.poll();

            for (int i = 0; i < 4; i++) {
                int newX = current[0] + dx[i];
                int newY = current[1] + dy[i];

                if (valid(newX, newY) && table[newX][newY] > h) {
                    stack.push(new int[]{newX, newY});
                    visited[newX][newY] = true;
                }
            }
        }
    }

    public static boolean valid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N && !visited[x][y];
    }
}