import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int count = (int) (Math.pow(2, N) - 1);
        sb.append(count).append("\n");
        
        hanoi(N, 1, 2, 3, sb);
        System.out.println(sb);
    }

    private static void hanoi(int n, int start, int mid, int end, StringBuilder sb) {
        if (n == 1) {
            sb.append(start).append(" ").append(end).append("\n");
            return;
        }

        // 일단 n - 1개 이동 (1 -> 2)
        hanoi(n - 1, start, end, mid, sb);

        // 맨 아래 원반을 3으로 이동
        sb.append(start).append(" ").append(end).append("\n");

        // 2에 있는 n - 1개를 3으로 이동
        hanoi(n -1, mid, start, end, sb);
    }
}