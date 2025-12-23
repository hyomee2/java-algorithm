import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // win[i]: 돌이 i개 있을 때 지금 차례인 사람이 이기는가
        boolean[] win = new boolean[N + 1];
        win[1] = true;
        if (N >= 2) win[2] = false;
        if (N >= 3) win[3] = true;
        if (N >= 4) win[4] = true;
        if (N >= 5) win[5] = true;

        for (int i = 6; i < N + 1; i++) {
            win[i] = !win[i - 1] || !win[i - 3] || !win[i - 4];
        }

        String result = win[N] ? "SK" : "CY";
        System.out.println(result);
    }
}