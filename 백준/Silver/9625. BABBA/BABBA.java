import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        int[] numOfA = new int[K + 1];
        int[] numOfB = new int[K + 1];
        numOfA[1] = 0;
        numOfB[1] = 1;

        for (int i = 2; i < K + 1; i++) {
            numOfA[i] = numOfB[i - 1];
            numOfB[i] = numOfA[i - 1] + numOfB[i - 1];
        }

        StringBuilder sb = new StringBuilder();
        sb.append(numOfA[K]).append(' ').append(numOfB[K]);
        System.out.println(sb);
    }
}