import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N, M, index, max, temp, order;
        int[] count;
        Deque<Node> queue;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(br.readLine());

        for (int i = 1; i <= c; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());  // 문서 개수
            M = Integer.parseInt(st.nextToken());  // 문서가 큐에서 몇번째에 놓여있는지
            queue = new ArrayDeque<>();
            index = 0;  // 맨 처음에 각 문서의 인덱스
            max = 0;  // 가장 큰 우선 순위
            order = 0; // 몇번째로 인쇄되는지

            // 큐 안의 숫자들
            st = new StringTokenizer(br.readLine(), " ");
            count = new int[10];

            while (st.hasMoreTokens()) {
                temp = Integer.parseInt(st.nextToken());
                if (temp > max) {
                    max = temp;
                }
                count[temp]++;
                queue.offerLast(new Node(index++, temp));
            }

            while(!queue.isEmpty()) {
                Node node = queue.pollFirst();

                if (node.num < max) {
                    queue.offerLast(node);
                } else {
                    order++;
                    count[node.num]--;
                    if (node.index == M) {
                        sb.append(order).append("\n");
                        break;
                    }

                    // max 갱신
                    while (max > 0 && count[max] == 0) max--;
                }
            }
        }

        System.out.println(sb);
    }

    static class Node {
        int index;
        int num;

        Node(int index, int num) {
            this.index = index;
            this.num = num;
        }
    }
}