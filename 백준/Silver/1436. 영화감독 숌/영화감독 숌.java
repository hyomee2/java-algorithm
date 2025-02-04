import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int title = 666;

        while(n != 0) {
            if (Integer.toString(title).contains("666")) n--;
            title++;
        }

        System.out.println(title - 1);
    }
}