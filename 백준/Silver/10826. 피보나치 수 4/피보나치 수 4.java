import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        BigInteger[] dp = new BigInteger[n + 1];
        if (n >= 0) dp[0] = BigInteger.ZERO;
        if (n >= 1) dp[1] = BigInteger.ONE;

        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1].add(dp[i - 2]);
        }

        System.out.println(dp[n]);
    }
}