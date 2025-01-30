import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        Stack<Character> stack;

        for (int i = 0; i < n; i++) {
            stack = new Stack<>();
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                if (stack.isEmpty() || str.charAt(j) != stack.peek()) {
                    stack.push(str.charAt(j));
                } else {
                    stack.pop();
                }
            }

            if (stack.isEmpty()) {
                count++;
            }
        }

        System.out.println(count);
    }
}