import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] temp = new int[N];;
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                temp[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(temp);

            Deque<Integer> deque = new LinkedList<>();

            for (int j = 0; j < N; j++) {
                if (j % 2 == 0) {
                    deque.addFirst(temp[j]);
                } else {
                    deque.addLast(temp[j]);
                }
            }

            Integer[] result = deque.toArray(Integer[]::new);

            int level = 0;

            for (int j = 0; j < N - 1; j++) {
                level = Math.max(level, Math.abs(result[j + 1] - result[j]));
            }

            // 처음, 마지막 것 검사(원형)
            level = Math.max(level, Math.abs(result[N - 1] - result[0]));
            sb.append(level).append("\n");
        }

        System.out.println(sb);
    }
}