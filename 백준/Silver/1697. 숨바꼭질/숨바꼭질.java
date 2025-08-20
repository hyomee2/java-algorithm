import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dp = new int[100002];
        dp[N] = 0;

        if (N >= K) {
            sb.append(N - K);
        } else {
            for (int i = 0; i <= N; i++) {
                dp[N - i] = i;
            }

            for (int i = N + 1; i <= K + 1; i++) {
                if (i % 2 == 0) {
                    dp[i] = Math.min(dp[i - 1] + 1, dp[i / 2] + 1);
                    dp[i - 1] = Math.min(dp[i - 1], dp[i] + 1);
                } else {
                    dp[i] = dp[i - 1] + 1;
                }
            }
            sb.append(dp[K]);
        }

        System.out.println(sb);
    }
}