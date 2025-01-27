import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2;
        String name = br.readLine();
        int[] numOfChars = new int[26];
        int numOfOdds = 0;
        int indexOfOdd = -1;

        for (int i = 0; i < name.length(); i++) {
            numOfChars[name.charAt(i) - 'A']++;
        }

        for (int i = 0; i < 26; i++) {
            if (numOfChars[i] % 2 != 0) {
                numOfOdds++;
            }
        }

        if (numOfOdds > 1) {
            System.out.println("I'm Sorry Hansoo");
        } else {
            for (int i = 0; i < 26; i++) {
                String repeat = String.valueOf((char)(i + 'A')).repeat(Math.max(0, numOfChars[i] / 2));
                if (numOfChars[i] > 0 && numOfChars[i] % 2 == 0) {
                    sb.append(repeat);
                } else if (numOfChars[i] > 1)  {
                    indexOfOdd = i;
                    sb.append(repeat);
                } else if (numOfChars[i] == 1){
                    indexOfOdd = i;
                }
            }

            sb2 = new StringBuilder(sb).reverse();

            if (indexOfOdd != -1) {
                sb.append((char)(indexOfOdd + 'A'));
            }
            sb.append(sb2);

            System.out.println(sb);
        }
    }
}