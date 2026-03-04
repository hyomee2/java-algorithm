import java.io.*;
import java.util.*;

public class Main {
    static int[][] array;
    static int blue = 0;
    static int white = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        array = new int[N][N];

        // array 만들기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        split(0, 0, N - 1, N - 1);
        sb.append(white).append("\n").append(blue);
        System.out.println(sb);
    }

    // 색종이 색이 일치하는지 체크
    public static int check(int startX, int startY, int endX, int endY) {
        int color = array[startX][startY];
        for (int i = startX; i <= endX; i++) {
            for (int j = startY; j <= endY; j++) {
                if (array[i][j] != color) {
                    return -1;
                }
            }
        }
        return color;
    }

    // 분할
    public static void split(int startX, int startY, int endX, int endY) {
        int color = check(startX, startY, endX, endY); // blue면 1, white면 0, 섞여있으면 -1 반환
        if (color == 1) {
            blue++;
            return;
        }

        if (color == 0) {
            white++;
            return;
        }

        int midX = (startX + endX) / 2;
        int midY = (startY + endY) / 2;
        split(startX, startY, midX, midY);
        split(midX + 1, startY, endX, midY);
        split(startX, midY + 1, midX, endY);
        split(midX + 1, midY + 1, endX, endY);
    }
}