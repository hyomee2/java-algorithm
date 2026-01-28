import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        boolean isSorted = false;
        int n = st.countTokens();
        int[] arr = new int[n + 1];
        int temp;

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        while (!isSorted) {
            for (int i = 1; i < n; i++) {
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;

                    for (int j = 1; j <= n; j++) {
                        sb.append(arr[j]).append(" ");
                    }
                    sb.append('\n');
                }
            }

            isSorted = true;
            for (int i = 1; i <= n; i++) {
                if (arr[i] != i) {
                    isSorted = false;
                    break;
                }
            }
        }

        System.out.println(sb);
    }
}