import java.util.*;
import java.io.*;

public class Main {
    static int start, end;
    static ArrayList<Node>[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        int left = 1;
        int right = 1;
        int answer = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            arr[A].add(new Node(B, C));
            arr[B].add(new Node(A, C));
            right = Math.max(right, C);
        }

        st = new StringTokenizer(br.readLine(), " ");
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        while (left <= right) {
            int mid = (left + right) / 2; // 한계
            visited = new boolean[N + 1];
            if (dfs(start, end, mid)) { // mid로 가능?
                answer = mid;  // 가능하면 answer 갱신
                left = mid + 1; // 더 무거운 한계도 시도
            } else {
                right = mid - 1; // mid로 불가능 -> 한계 줄임
            }
        }

        System.out.println(answer);
    }

    public static boolean dfs(int s, int e, int l) {
        if (s == e) return true;
        visited[s] = true;

        for (Node n : arr[s]) {
            if (!visited[n.island] && n.weight >= l) {
                if (dfs(n.island, e, l)) {
                    return true;
                }
            }
        }
        return false;
    }
}

class Node {
    int island, weight;
    Node(int i, int w) {
        island = i; weight = w;
    }
}