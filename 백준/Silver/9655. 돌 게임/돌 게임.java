import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] dp = new String[N + 1];
        
        if (N >= 1) dp[1] = "SK";
        if (N >= 2) dp[2] = "CY";
        if (N >= 3) dp[3] = "SK";

        for (int i = 4; i < N + 1; i++) {
            dp[i] = (Objects.equals(dp[i - 3], "SK")) ? "CY" : "SK";
        }
        System.out.println(dp[N]);
    }
}