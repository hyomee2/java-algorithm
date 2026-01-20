import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Double> stack = new ArrayDeque<>();
        double[] arr = new double[N];
        double a, b;
        char c;
        
        String str = br.readLine();

        for (int i = 0; i < N; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }

        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                stack.push(arr[c - 'A']);
            } else {
                b = stack.pop();
                a = stack.pop();
                switch(c) {
                    case '+': {
                        stack.push(a + b);
                        break;
                    }
                    case '-': {
                        stack.push(a - b);
                        break;
                    }
                    case '*': {
                        stack.push(a * b);
                        break;
                    }
                    case '/': {
                        stack.push(a / b);
                        break;
                    }
                }
            }
        }

        System.out.printf("%.2f", stack.pop());
    }
}