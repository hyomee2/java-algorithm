import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] child = new int[N + 1];
        int[] dp = new int[N + 1];  // dp[n]: n으로 끝나는 1씩 증가하는 부분 수열의 길이
        int max = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i < N + 1; i++) {
            child[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N + 1; i++) {
            int c = child[i];
            dp[c] = dp[c - 1] + 1;
            max = Math.max(max, dp[c]);
        }

        System.out.println(N - max);
    }
}