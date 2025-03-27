import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] trees = new int[N];
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(trees);

        int answer = 0;
        int start = 0;
        int end = trees[trees.length - 1];
        long sumOfTrees;
        int mid;

        while (start <= end) {
            mid = (start + end) / 2;
            sumOfTrees = 0;

            for (int tree : trees) {
                sumOfTrees += ((tree < mid) ? 0 : (tree - mid));
            }

            if (sumOfTrees >= M) {  // 일단 필요한 나무만큼 가져갈 수 있지만, 우리는 최댓값을 구하고 있으니 한 번 더 시행
                answer = mid;
                start = mid + 1; // 더 높은 높이가 가능한지 탐색
            } else {  // 나무의 높이를 줄여야 함
                end = mid - 1;
            }
        }

        System.out.println(answer);
    }
}