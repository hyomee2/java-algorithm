import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] isVisited;
    static int count;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        isVisited = new boolean[N][N];
        ArrayList<Integer> counts = new ArrayList<Integer>();

        // 지도 만들기
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = row.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !isVisited[i][j]) {
                    count = 0;
                    dfs(i, j);
                    counts.add(count);
                }
            }
        }

        sb.append(counts.size()).append("\n");
        Collections.sort(counts);

        for (int i = 0; i < counts.size(); i++) {
            sb.append(counts.get(i)).append("\n");
        }

        System.out.println(sb);
    }

    public static void dfs(int x, int y) {
        isVisited[x][y] = true;
        count++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (!isValid(nx, ny)) continue;

            dfs(nx, ny);
        }
    }

    public static boolean isValid(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < N && !isVisited[x][y] && map[x][y] == 1);
    }
}