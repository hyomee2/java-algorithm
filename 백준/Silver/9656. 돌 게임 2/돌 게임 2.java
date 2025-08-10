import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] dp = new boolean[N];
        dp[0] = true; // 상근이가 질 경우(마지막 돌을 가져갈 경우) true

        if (N >= 2) {
            dp[1] = false;
        }
        if (N >= 3) {
            dp[2] = true;
        }

        for (int i = 3; i < N; i++) {
            if (!dp[i - 1] && !dp[i - 3]) {
                dp[i] = true;
            }
        }

        String answer = dp[N - 1] ? "CY" : "SK";
        System.out.println(answer);
    }
}