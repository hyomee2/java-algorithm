import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        Deque<Integer> queue = new ArrayDeque<>();
        String command;
        int num;
        Integer temp;
        boolean isPush;

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            command = st.nextToken();
            temp = null;
            isPush = false;

            switch(command) {
                case "push": {
                    num = Integer.parseInt(st.nextToken());
                    queue.add(num);
                    isPush = true;
                    break;
                }

                case "pop": {
                    temp = queue.poll();
                    temp = (temp == null) ? -1 : temp;
                    break;
                }

                case "size": {
                    temp = queue.size();
                    break;
                }

                case "empty": {
                    temp = queue.isEmpty() ? 1 : 0;
                    break;
                }

                case "front": {
                    temp = queue.peekFirst();
                    temp = (temp == null) ? -1 : temp;
                    break;
                }

                case "back": {
                    temp = queue.peekLast();
                    temp = (temp == null) ? -1 : temp;
                    break;
                }
            }

            if (!isPush) {
                System.out.println(temp);
            }
        }
    }
}