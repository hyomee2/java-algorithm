import java.util.*;
import java.io.*;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= N; j++) {
                if (i < j) break; // 무방향 그래프이므로 양방향 체크가 필요없음.
                int connected = Integer.parseInt(st.nextToken());
                if (connected == 1) {
                    union(i, j);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            find(i);
        }

        // 여행 계획 내의 도시의 rootNode를 담는 rootCity
        // 만약 담겨있는 rootNode의 개수가 1개라면 모두 연결되어 있으므로 여행이 가능
        HashSet<Integer> rootCity = new HashSet<>();
        st = new StringTokenizer(br.readLine(), " ");
        while (st.hasMoreTokens()) {
            int city = Integer.parseInt(st.nextToken());
            rootCity.add(parent[city]);
        }

        String answer = rootCity.size() == 1 ? "YES" : "NO";
        System.out.println(answer);
    }

    public static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }

    public static int find(int a) {
        if (parent[a] != a) {
            parent[a] = find(parent[a]);
        }
        return parent[a];
    }
}