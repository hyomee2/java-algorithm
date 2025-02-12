import java.util.*;
import java.io.*;
import java.awt.*;

public class Main {
    static int time = 0;
    static int R, C;
    static char[][] map;
    static boolean[][] isJihunVisited;
    static boolean[][] isFireVisited;
    static Queue<Point> jihunQue = new LinkedList<>();
    static Queue<Point> fireQue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        isJihunVisited = new boolean[R][C];
        isFireVisited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String row = br.readLine();

            for (int j = 0; j < C; j++){
                map[i][j] = row.charAt(j);

                if (map[i][j] == 'J') {
                    jihunQue.add(new Point(i, j));
                    isJihunVisited[i][j] = true;
                } else if (map[i][j] == 'F') {
                    fireQue.add(new Point(i, j));
                    isFireVisited[i][j] = true;
                }
            }
        }

        bfs();
        System.out.println("IMPOSSIBLE");
    }

    public static void bfs() {
        int[][] coor = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};

        // 지훈이가 빠져나오기 전 동안 반복
        while(!jihunQue.isEmpty()) {
            int jihunQueSize = jihunQue.size();
            int fireQueSize = fireQue.size();
            
            for (int i = 0; i < fireQueSize; i++) {
                Point fire = fireQue.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = fire.x + coor[j][0];
                    int ny = fire.y + coor[j][1];

                    if (!isValid(nx, ny) || map[nx][ny] == '#' || isFireVisited[nx][ny])
                        continue;

                    isFireVisited[nx][ny] = true;
                    map[nx][ny] = 'F';
                    fireQue.add(new Point(nx, ny));
                }
            }

            for (int i = 0; i < jihunQueSize; i++) {
                Point jihun = jihunQue.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = jihun.x + coor[j][0];
                    int ny = jihun.y + coor[j][1];

                    if (!isValid(nx, ny)) {
                        time++;
                        System.out.println(time);
                        System.exit(0);
                    }

                    if (map[nx][ny] != '.' || isJihunVisited[nx][ny])
                        continue;
                    isJihunVisited[nx][ny] = true;
                    jihunQue.add(new Point(nx, ny));
                }
            }

            time++;
        }

    }

    public static boolean isValid(int x, int y) {
        return 0 <= x && x < R && 0 <= y && y < C;
    }
}
