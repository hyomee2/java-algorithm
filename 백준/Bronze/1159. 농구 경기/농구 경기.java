import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] numOfNames = new int[26];
        boolean isSelectable = false;

        if (num < 5) {
            System.out.println("PREDAJA");
        } else {
            for (int i = 0; i < num; i++) {
                String name = br.readLine();
                char firstOfName = name.charAt(0);
                numOfNames[firstOfName - 'a']++;
            }

            for (int i = 0; i < 26; i++) {
                if (numOfNames[i] >= 5) {
                    System.out.print((char)(i + 'a'));
                    isSelectable = true;
                }
            }

            if (!isSelectable) {
                System.out.println("PREDAJA");
            }
        }
    }
}