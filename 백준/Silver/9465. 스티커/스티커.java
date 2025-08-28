import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] table = new int[2][n + 1];
            int[][] dp = new int[2][n + 1];

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j < n + 1; j++) {
                table[0][j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j < n + 1; j++) {
                table[1][j] = Integer.parseInt(st.nextToken());
            }

            dp[0][1] = table[0][1];
            dp[1][1] = table[1][1];

            for (int j = 2; j < n + 1; j++) {
                dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + table[0][j];
                dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + table[1][j];
            }

            sb.append(Math.max(dp[0][n], dp[1][n])).append("\n");
        }

        System.out.println(sb);
    }
}