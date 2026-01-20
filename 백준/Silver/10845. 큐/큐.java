import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();;

        Deque<Integer> queue = new ArrayDeque<>();
        String command;
        int num;
        Integer temp;

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            command = st.nextToken();

            switch(command) {
                case "push": {
                    num = Integer.parseInt(st.nextToken());
                    queue.add(num);
                    break;
                }

                case "pop": {
                    temp = queue.isEmpty() ? -1 : queue.poll();
                    sb.append(temp).append('\n');
                    break;
                }

                case "size": {
                    temp = queue.size();
                    sb.append(temp).append('\n');
                    break;
                }

                case "empty": {
                    temp = queue.isEmpty() ? 1 : 0;
                    sb.append(temp).append('\n');
                    break;
                }

                case "front": {
                    temp = (queue.isEmpty()) ? -1 : queue.peekFirst();
                    sb.append(temp).append('\n');
                    break;
                }

                case "back": {
                    temp = (queue.isEmpty()) ? -1 : queue.peekLast();
                    sb.append(temp).append('\n');
                    break;
                }
            }
        }

        System.out.print(sb);
    }
}