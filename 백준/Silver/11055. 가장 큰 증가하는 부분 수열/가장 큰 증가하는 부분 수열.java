import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] A = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            dp[i] = A[i];
            for (int j = 1; j < i; j++) {
                if (A[j] < A[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + A[i]);
                }
            }
        }

        int max = Arrays.stream(dp).max().getAsInt();
        System.out.println(max);
    }
}