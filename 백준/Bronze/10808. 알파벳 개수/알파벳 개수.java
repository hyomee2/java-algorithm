import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String word = br.readLine();

        int[] countList = new int[26];

        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            countList[c - 'a']++;
        }

        for(int i = 0; i < countList.length; i++) {
            bw.write(countList[i] + " ");
        }

        bw.flush();
        bw.close();
    }
}