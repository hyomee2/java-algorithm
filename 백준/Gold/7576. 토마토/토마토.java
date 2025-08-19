import java.util.*;
import java.io.*;

public class Main {
    static int[][] table;
    static int M, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        table = new int[M][N];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};
        Queue<Node> queue = new LinkedList<>();

        int total = M * N;
        int tomato = 0;
        int count = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                int temp = Integer.parseInt(st.nextToken());
                table[j][i] = temp;
                if (temp == 1) {
                    queue.add(new Node(j, i, 0));
                    tomato++;
                } else if (temp == -1) {
                    total -= 1;
                }
            }
        }
        
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < 4; i++) {
                if (isValid(node.x + dx[i], node.y + dy[i])) {
                    queue.add(new Node(node.x + dx[i], node.y + dy[i], node.c + 1));
                    table[node.x + dx[i]][node.y + dy[i]] = 1;
                    tomato++;
                    count = Math.max(count, node.c + 1);
                }
            }
        }

        int answer = tomato == total ? count : -1;
        System.out.println(answer);
    }

    public static boolean isValid(int x, int y) {
        return x >= 0 && x < M && y >= 0 && y < N && table[x][y] == 0;
    }
}

class Node {
    int x, y, c;
    Node(int x, int y, int c) {
        this.x = x;
        this.y = y;
        this.c = c;
    }
}