import java.util.*;
import java.io.*;

public class Main {
    static int M, N, K, count, x, y;
    static boolean[][] isVisited;
    static int[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            // 지도 & 방문여부 만들기
            map = new int[M][N];
            isVisited = new boolean[M][N];
            count = 0;

            // 입력대로 배추 위치 표시하기
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());

                map[x][y] = 1;
            }

            // 깊이우선탐색을 통해 최소의 배추흰지렁이 마리 수 출력
            for (int j = 0; j < M; j++) {
                for(int k = 0; k < N; k++) {
                    if (!isVisited[j][k] && map[j][k] ==1) {
                        dfs(j ,k);
                        count++;
                    }
                }
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }

    public static void dfs(int x, int y) {
        isVisited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (!isValid(nx, ny)) continue;
            
            dfs(nx, ny);
        }
    }

    public static boolean isValid(int x, int y) {
        return (x >= 0 && x < M && y >= 0 && y < N && !isVisited[x][y] && map[x][y] == 1);
    }
}