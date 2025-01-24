import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        HashMap<Integer, String> numToName = new HashMap<>();
        HashMap<String, Integer> nameToNum = new HashMap<>();

        for (int i = 0; i < m; i++) {
            String pokemon  = br.readLine();
            numToName.put(i + 1, pokemon);
            nameToNum.put(pokemon, i + 1);
        }

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            if (Character.isDigit(input.charAt(0))) {
                int num = Integer.parseInt(input);
                bw.write(numToName.get(num));
            } else {
                bw.write(nameToNum.get(input) + "");
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}