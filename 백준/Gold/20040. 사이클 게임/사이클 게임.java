import java.util.*;
import java.io.*;

public class Main {
    static StringTokenizer st;
    static int node1, node2, answer = 0;
    static int[] parent, size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n];
        size = new int[n];

        Arrays.fill(size, 1);

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            node1 = Integer.parseInt(st.nextToken());
            node2 = Integer.parseInt(st.nextToken());
            union(node1, node2);
        }

        for (int i = 2; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            node1 = Integer.parseInt(st.nextToken());
            node2 = Integer.parseInt(st.nextToken());

            if (find(node1) == find(node2)) {
                answer = i + 1;
                break;
            }

            union(node1, node2);
        }

        System.out.println(answer);
    }

    public static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            parent[rootB] = rootA;
            size[rootA] += size[rootB];
        }
    }

    public static int find(int a) {
        if (parent[a] != a) {
            parent[a] = find(parent[a]);
        }

        return parent[a];
    }
}