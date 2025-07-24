import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] adjList;
    static boolean[] isVisited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N + 1];

        for (int i = 0; i < N + 1; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            adjList[node1].add(node2);
            adjList[node2].add(node1);
        }

        for (ArrayList<Integer> n : adjList) {
            n.sort(Collections.reverseOrder());
        }

        isVisited = new boolean[N + 1];
        dfs(V);

        for (ArrayList<Integer> n : adjList) {
            Collections.sort(n);
        }

        isVisited = new boolean[N + 1];
        bfs(V);

        System.out.println(sb);
    }

    public static void dfs(int start) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int node = stack.pop();

            if (!isVisited[node]) {
                isVisited[node] = true;
                sb.append(node).append(" ");

                for (int n : adjList[node]) {
                    if (!isVisited[n]) {
                        stack.push(n);
                    }
                }
            }
        }

        sb.append("\n");
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        isVisited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            sb.append(node).append(" ");

            for (int n : adjList[node]) {
                if (!isVisited[n]) {
                    queue.add(n);
                    isVisited[n] = true;
                }
            }
        }
    }
}