import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        dp[1] = 0;
        if (N >= 2) dp[2] = 1;
        if (N >= 3) dp[3] = 1;

        for (int i = 4; i <= N; i++) {
            dp[i] = 1000001; // 큰 값

            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            } else {  // i % 2 != 0
                dp[i] = Math.min(dp[i], dp[i - 1] + 1);
            }

            if ((i - 2) % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i - 2] + 2);
            } else if ((i - 1) % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i - 1] + 1);
            } else {    // i % 3 == 0
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }

        System.out.println(dp[N]);
    }
}