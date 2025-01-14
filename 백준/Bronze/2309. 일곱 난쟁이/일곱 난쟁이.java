import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> list = new ArrayList<>();

        int total = 100;
        int sum = 0;

        for (int i = 0; i < 9; i++) {
            int value = Integer.parseInt(br.readLine());
            list.add(value);
            sum += value;
        }

        Collections.sort(list);

        loop:
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (list.get(j) + list.get(i) == sum - total) {
                    list.remove(j);
                    list.remove(i);
                    break loop;
                }
            }
        }

        for (int h : list) {
            bw.write(h + "\n");
        }
        
        bw.flush();
        bw.close();
    }
}