import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i) >= 'a' && str.charAt(i) <= 'm') || (str.charAt(i) >= 'A' && str.charAt(i) <= 'M')) {
                bw.write((char) (str.charAt(i) + 13));
            } else if ((str.charAt(i) >= 'n' && str.charAt(i) <= 'z') || (str.charAt(i) >= 'N' && str.charAt(i) <= 'Z')) {
                bw.write((char) (str.charAt(i) - 13));
            } else {
                bw.write(str.charAt(i));
            }
        }

        bw.flush();
        bw.close();
    }
}