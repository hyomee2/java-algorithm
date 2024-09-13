import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<Integer>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(br.readLine());
        int num;
        int x;
        int result;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            num = Integer.parseInt(st.nextToken());

            switch(num) {
                case 1 : {
                    x = Integer.parseInt(st.nextToken());
                    stack.push(x);
                    break;
                }

                case 2 : {
                    result = stack.isEmpty() ? -1 : stack.pop();
                    bw.write(String.valueOf(result) + "\n");
                    break;
                }

                case 3 : {
                    bw.write(String.valueOf(stack.size()) + "\n");
                    break;
                }

                case 4 : {
                    result = stack.isEmpty() ? 1 : 0;
                    bw.write(String.valueOf(result)+ "\n");

                    break;
                }

                case 5 : {
                    result = stack.isEmpty() ? -1 : stack.peek();
                    bw.write(String.valueOf(result)+ "\n");
                    break;
                }
            }

        }
        bw.flush();
        bw.close();
    }
}