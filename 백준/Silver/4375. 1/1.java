
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;

        while((str = br.readLine()) != null) {
            long n = Long.parseLong(str);
            if (n == 1) {
                System.out.println(1);
                continue;
            }
            String num = "11";
            long remainder = 11 % n;
            int length = 2;
            while (true) {
                if (remainder == 0) {
                    System.out.println(length);
                    break;
                } else {
                    remainder = (remainder * 10 + 1) % n;
                    length++;
                }
            }
        }
    }
}