import java.util.*;
import java.io.*;

public class Main {
    public static int N, M, count, maxCount = 0;
    public static List<Integer>[] list;
    public static int[] countList;
    public static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new List[N];
        countList = new int[N];  // 각 컴퓨터가 해킹할 수 있는 컴퓨터의 수

        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int end = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            list[start - 1].add(end - 1);
        }

        for (int i = 0; i < N; i++) {
            isVisited = new boolean[N];
            count = 0;
            dfs(i);
            countList[i] = count;
            maxCount = Math.max(maxCount, count);
        }

        for (int i = 0; i < N; i++) {
            if (countList[i] == maxCount) sb.append(i + 1).append(" ");
        }

        System.out.println(sb);
    }

    public static void dfs(int node) {
        isVisited[node] = true;
        count++;

        for (int i : list[node]) {
            if (!isVisited[i]) dfs(i);
        }
    }
}