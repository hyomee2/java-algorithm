import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st1= new StringTokenizer(br.readLine(), " ");
        int num = Integer.parseInt(st1.nextToken());
        int n = Integer.parseInt(st1.nextToken());

        StringTokenizer st2= new StringTokenizer(br.readLine(), " ");
        int[] temperatures = new int[num];
        int[] sums = new int[num - n + 1];

        for (int i = 0; i < temperatures.length; i++) {
            temperatures[i] = Integer.parseInt(st2.nextToken());
        }

        for (int i = 0; i < sums.length; i++) {
            for (int j = i; j < i + n; j++) {
                sums[i] += temperatures[j];
            }
        }

        Arrays.sort(sums);
        System.out.print(sums[sums.length - 1]);
    }
}