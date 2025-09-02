import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coins = new int[n];
        int[] dp = new int[k + 1];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        Arrays.fill(dp, 100001);
        dp[0] = 0;

        for (int c : coins) {
            for (int i = c; i <= k; i++) {
                dp[i] = Math.min(dp[i], dp[i - c] + 1);
            }
        }

        System.out.println(dp[k] == 100001 ? -1 : dp[k]);
    }
}