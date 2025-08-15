import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int N;
        long[] dp;

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            dp = new long[N + 1];
            dp[1] = 1;
            if (N >= 2) dp[2] = 1;
            if (N >= 3) dp[3] = 1;

            for (int j = 4; j < N + 1; j++) {
                dp[j] = dp[j - 3] + dp[j - 2];
            }

            sb.append(dp[N]).append("\n");
        }

        System.out.println(sb);
    }
}