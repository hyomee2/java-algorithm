import java.io.*;
import java.util.*;

public class Main {
    static char[][] tree;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        tree = new char[2][N];
        StringTokenizer st;
        char a, b, c;

        // tree 만들기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = st.nextToken().charAt(0);
            b = st.nextToken().charAt(0);
            c = st.nextToken().charAt(0);

            tree[0][a - 'A'] = b;
            tree[1][a - 'A'] = c;
        }

        preorder(0);
        sb.append('\n');

        inorder(0);
        sb.append('\n');

        postorder(0);
        sb.append('\n');

        System.out.println(sb);
    }

    // 전위순회
    public static void preorder(int n) {
        // 현재 노드 (루트)
        sb.append((char) (n + 'A'));

        // 왼쪽 노드
        if (tree[0][n] != '.') {
            preorder(tree[0][n] - 'A');
        }

        // 오른쪽 노드
        if (tree[1][n] != '.') {
            preorder(tree[1][n] - 'A');
        }
    }

    // 중위순회
    public static void inorder(int n) {
        // 왼쪽 노드
        if (tree[0][n] != '.') {
            inorder(tree[0][n] - 'A');
        }

        // 현재 노드 (루트)
        sb.append((char) (n + 'A'));

        // 오른쪽 노드
        if (tree[1][n] != '.') {
            inorder(tree[1][n] - 'A');
        }
    }

    // 후위순회
    public static void postorder(int n) {
        // 왼쪽 노드
        if (tree[0][n] != '.') {
            postorder(tree[0][n] - 'A');
        }

        // 오른쪽 노드
        if (tree[1][n] != '.') {
            postorder(tree[1][n] - 'A');
        }

        // 현재 노드 (루트)
        sb.append((char) (n + 'A'));
    }
}