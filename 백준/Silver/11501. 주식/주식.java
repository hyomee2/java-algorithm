import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int N, max;
        long sum;
        int[] arr;

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            arr = new int[N];
            max = -1;
            sum = 0;

            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = N - 1; j >= 0; j--) {
                if (max < arr[j]) {
                    max = arr[j];
                } else if (max > arr[j]) {
                    sum += (max - arr[j]);
                }
            }

            sb.append(sum).append("\n");
        }

        System.out.print(sb);
    }
}