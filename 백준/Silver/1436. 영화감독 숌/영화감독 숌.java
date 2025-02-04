import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String title = "666";

        while(n != 0) {
            if (title.contains("666")) {
                n--;
            }

            title = n == 0 ? title : (Integer.parseInt(title) + 1) + "";
        }

        System.out.println(title);
    }
}