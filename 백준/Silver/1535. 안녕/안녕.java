import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] L = new int[N + 1];
        int[] J = new int[N + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            L[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            J[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N + 1][100];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= 99; j++) {
                // i번째 사람에게 못말하는 경우
                dp[i][j] = dp[i - 1][j];
                // i번째 사람에게 말할 수 있는 경우
                if (j - L[i] >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - L[i]] + J[i]);
                }
            }
        }
        System.out.println(dp[N][99]);
    }
}