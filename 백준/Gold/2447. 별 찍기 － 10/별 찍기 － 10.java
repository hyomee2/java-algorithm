import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            for  (int j = 1; j <= N; j++) {
                drawStars(i, j, N, sb);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    /*
    * <공백인 경우>
    * e.g., 27
    * N = 27일 때 가운데, N = 9일 때 가운데, N = 3일 때 가운데
    * (위치 / (size / 3)) % 3 == 1 이면 공백이다 (0, 1, 2 중 가운데)
    *
    * */
    private static void drawStars(int row, int col, int n, StringBuilder sb) {
        if (n == 1) {
            sb.append('*');
            return;
        }

        if ((row - 1) / (n / 3) % 3 == 1 && (col - 1) / (n / 3) % 3 == 1) {
            sb.append(' ');
        } else {
            drawStars(row, col, n / 3, sb);
        }
    }
}