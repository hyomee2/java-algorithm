import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        String pattern = br.readLine();
        int indexOfStar = pattern.indexOf("*");


        for (int i = 0; i < num; i++) {
            boolean isPatterned = true;
            String str = br.readLine();
            int gapOfLength = str.length() - pattern.length();
            for (int j = 0; j < indexOfStar; j++) {
                if (str.charAt(j) != pattern.charAt(j)) {
                    isPatterned = false;
                    break;
                }
            }

            for (int j = indexOfStar + 1; j < pattern.length(); j++) {
                if (j + gapOfLength < 0 || j + gapOfLength > str.length() - 1 || gapOfLength < -1) {
                    isPatterned = false;
                    break;
                } else if (pattern.charAt(j) != str.charAt(j + gapOfLength)) {
                    isPatterned = false;
                    break;
                }
            }

            if (isPatterned) {
                System.out.println("DA");
            } else {
                System.out.println("NE");
            }
        }
    }
}