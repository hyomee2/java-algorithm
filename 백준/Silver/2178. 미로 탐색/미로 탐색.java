import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] isVisited;
    static int[][] moves = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int[][] counts;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1];
        counts = new int[N + 1][M + 1];
        isVisited = new boolean[N + 1][M + 1];

        // 지도 만들기
        for (int i = 1; i < N + 1; i++) {
            String row = br.readLine();
            for (int j = 1; j < M + 1; j++) {
                map[i][j] = row.charAt(j - 1) - '0';
            }
        }

        bfs(1, 1);
    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        isVisited[x][y] = true;
        counts[x][y] = 1;

        while (!queue.isEmpty()) {
            int[] n = queue.poll();
            int nx = n[0];
            int ny = n[1];

            if (nx == N && ny == M) {
                System.out.println(counts[N][M]);
            }

            for (int[] move : moves) {
                int newX = nx + move[0];
                int newY = ny + move[1];
                if (isValid(newX, newY)) {
                    queue.add(new int[] {newX, newY});
                    isVisited[newX][newY] = true;
                    counts[newX][newY] = counts[nx][ny] + 1;
                }
            }
        }
    }

    // 이동할 수 있는 칸인지 체크
    public static boolean isValid(int x, int y) {
        return x > 0 && x <= N && y > 0 && y <= M && map[x][y] == 1 && !isVisited[x][y];
    }
}