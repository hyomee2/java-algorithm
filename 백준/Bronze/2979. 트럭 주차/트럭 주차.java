import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int fare = 0;
        int[] times = new int[99];

        for (int i = 0; i < 3; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st1.nextToken());
            int end = Integer.parseInt(st1.nextToken());
            for (int j = start; j < end; j++) {
                times[j - 1]++;
            }
        }

        for (int i = 0; i < 99; i++) {
            switch(times[i]){
                case 1:
                    fare += times[i] * a;
                    break;
                case 2:
                    fare += times[i] * b;
                    break;
                case 3:
                    fare += times[i] * c;
                    break;
                default:
                    continue;
            }
        }

        bw.write(String.valueOf(fare));
        bw.flush();
        bw.close();
    }
}