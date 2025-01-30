import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());

        System.out.println(pow(a, b, c));
    }

    public static long pow(long base, long exp, long mod) {
        long result;
        if (exp == 0) return 1;
        if (exp == 1) return base % mod;

        // 지수가 짝수일 경우
        if (exp % 2 == 0) {
            result = pow(base, exp / 2, mod);
            return (result * result) % mod;
        } else {  // 지수가 홀수인 경우
            result = pow(base, (exp - 1) / 2, mod);
            return (base * result % mod * result) % mod;
        }
    }
}