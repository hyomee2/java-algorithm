import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] adjList;
    static boolean[] isVisited;
    static int count = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int numOfNode = Integer.parseInt(br.readLine());
        int numOfEdge = Integer.parseInt(br.readLine());

        adjList = new ArrayList[numOfNode + 1];
        isVisited = new boolean[numOfNode + 1];

        for (int i = 0; i < numOfNode + 1; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < numOfEdge; i++) {
            st = new StringTokenizer(br.readLine());

            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            adjList[node1].add(node2);
            adjList[node2].add(node1);
        }

        System.out.println(dfs(1));
    }

    public static int dfs(int num) {
        Stack<Integer> stack = new Stack<>();
        stack.push(num);

        while(!stack.isEmpty()) {
            int node = stack.pop();
            if (!isVisited[node]) {
                isVisited[node] = true;
                count++;

                for (int n : adjList[node]) {
                    stack.push(n);
                }
            }
        }

        return count;
    }
}