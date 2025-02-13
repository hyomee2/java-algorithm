import java.util.*;
import java.io.*;

public class Main {
    static int[][] attacks = {{9, 3, 1}, {9, 1, 3}, {3, 9, 1}, {3, 1, 9}, {1, 3, 9}, {1, 9, 3}};
    static int[] initial;
    static int[][][] isVisited;
    static int  count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        initial = new int[3];
        isVisited = new int[61][61][61];
        
        for (int i = 0; i < N; i++) {
            initial[i] = Integer.parseInt(st.nextToken());
        }
        
        bfs(initial);

        System.out.println(count);
    }

    static void bfs(int[] scv) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] {scv[0], scv[1], scv[2], 0});
        isVisited[scv[0]][scv[1]][scv[2]] = 1;

        while(!que.isEmpty()) {
            int[] current = que.poll();
            int a = current[0];
            int b = current[1];
            int c = current[2];
            count = current[3];

            if (a <= 0 && b <= 0 && c <= 0) return;

            for (int[] attack : attacks) {
                int a1 = Math.max(0, a - attack[0]);
                int b1 = Math.max(0, b - attack[1]);
                int c1 = Math.max(0, c - attack[2]);

                if (isVisited[a1][b1][c1] == 0) {
                    isVisited[a1][b1][c1] = 1;
                    que.add(new int[] {a1, b1, c1, count + 1});
                }
            }
        }
    }
}
