import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean flag;
        int count = 0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            int n = Integer.parseInt(st.nextToken());
            int sqrt = (int) Math.sqrt(n);

            flag = n >= 2;

            for (int j = 2; j <= sqrt; j++) {
                if (n % j == 0) { // 소수가 아님
                    flag = false;
                    break;
                }
            }

            if (flag) {
                count++;
            }
        }

        System.out.println(count);
    }
}