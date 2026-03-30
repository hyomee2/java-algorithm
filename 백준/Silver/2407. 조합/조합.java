import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        BigInteger answer = m < n / 2
                ? mult(n, n - m).divide(factorial(m))
                : mult(n, m).divide(factorial(n - m));

        System.out.println(answer);
    }

    public static BigInteger mult(int a, int b) {
        if (a == b) {
            return BigInteger.valueOf(1);
        }

        return BigInteger.valueOf(a).multiply( mult(a - 1, b));
    }

    public static BigInteger factorial(int n) {
        if (n == 0) {
            return BigInteger.ONE;
        }
        return BigInteger.valueOf(n).multiply(factorial(n - 1));
    }
}