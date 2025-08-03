import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] adjList;
    static boolean[] isVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        isVisited = new boolean[N + 1];
        int node1, node2, count = 0;

        // 인접리스트 만들기
        adjList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        // 인접리스트에 그래프 넣기
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            node1 = Integer.parseInt(st.nextToken());
            node2 = Integer.parseInt(st.nextToken());

            adjList[node1].add(node2);
            adjList[node2].add(node1);
        }

        // 탐색
        for (int i = 1; i <= N; i++) {
            // 이미 방문한 노드라면 패스
            if (isVisited[i]) continue;
            count++;
            dfs(i);
        }

        System.out.println(count);
    }

    public static void dfs(int start) {
        isVisited[start] = true;

        for (int n : adjList[start]) {
            if (isVisited[n]) continue;
            dfs(n);
        }
    }
}