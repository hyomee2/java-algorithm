import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final int INF = 50001;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];
        Arrays.fill(dp, INF);

        dp[0] = 0;

        for (int i = 2; i <= n; i++) {
            if (dp[i - 2] != INF) {
                dp[i] = Math.min(dp[i], dp[i - 2] + 1);
            }
            if (i >= 5 && dp[i - 5] != INF) {
                dp[i] = Math.min(dp[i], dp[i - 5] + 1);
            }
        }

        System.out.println(dp[n] == INF ? -1 : dp[n]);
    }
}