import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Deque<Integer> deque = new ArrayDeque<>();
        String command;
        int num;
        int temp;

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            command = st.nextToken();
            switch(command) {
                case "push_front":
                    deque.offerFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    deque.offerLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    temp = deque.isEmpty() ? -1 : deque.pollFirst();
                    sb.append(temp).append("\n");
                    break;
                case "pop_back":
                    temp = deque.isEmpty() ? -1 : deque.pollLast();
                    sb.append(temp).append("\n");
                    break;
                case "size":
                    temp = deque.size();
                    sb.append(temp).append("\n");
                    break;
                case "empty":
                    temp = deque.isEmpty() ? 1 : 0;
                    sb.append(temp).append("\n");
                    break;
                case "front":
                    temp = deque.isEmpty() ? -1 : deque.peekFirst();
                    sb.append(temp).append("\n");
                    break;
                case "back":
                    temp = deque.isEmpty() ? -1 : deque.peekLast();
                    sb.append(temp).append("\n");
                    break;
            }
        }

        System.out.print(sb);
    }
}