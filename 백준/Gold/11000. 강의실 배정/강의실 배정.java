import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] lectures = new int[N][2];
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> a.compareTo(b)
        );

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            lectures[i][0] = Integer.parseInt(st.nextToken());
            lectures[i][1] = Integer.parseInt(st.nextToken());
        }

        // 시작시간 기준 정렬
        Arrays.sort(lectures, Comparator.comparingInt(a -> a[0]));

        pq.offer(lectures[0][1]);

        for (int i = 1; i < N; i++) {
            int start = lectures[i][0];
            int end = lectures[i][1];

            if (pq.peek() <= start) {
                pq.poll();
            }

            pq.offer(end);
        }

        System.out.println(pq.size());
    }
}