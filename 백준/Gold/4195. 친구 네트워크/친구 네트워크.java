import java.util.*;
import java.io.*;

public class Main {
    static int[] parent, size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int F, count, index;
        HashMap<String, Integer> hashMap;
        String node1, node2;
        
        int numOfCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < numOfCase; i++) {
            F = Integer.parseInt(br.readLine());
            hashMap = new HashMap<>();
            parent = new int[2 * F];
            size =  new int[2 * F];
            index = 0;

            Arrays.fill(size, 1);
            
            for (int j = 0; j < 2 * F; j++) {
                parent[j] = j;
            }

            for (int j = 0; j < F; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                node1 = st.nextToken();
                node2 = st.nextToken();

                if (!hashMap.containsKey(node1)) {
                    hashMap.put(node1, index++);
                }
                if (!hashMap.containsKey(node2)) {
                    hashMap.put(node2, index++);
                }

                count= union(hashMap.get(node1), hashMap.get(node2));

                sb.append(count).append("\n");
            }
        }

        System.out.println(sb);
    }

    public static int union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            parent[rootB] = rootA;
            size[rootA] += size[rootB];
        }

        return size[find(a)];
    }

    public static int find(int a) {
        if (parent[a] != a) {
            parent[a] = find(parent[a]);
        }

        return parent[a];
    }
}