import java.util.*;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int x;
        int result = 0;
        for (int i = 1; i <= N; i++) {
            String str = sc.next();

            switch(str) {
                case "push" : {
                    x = sc.nextInt();
                    stack.push(x);
                    break;
                }

                case "pop" : {
                    result = stack.isEmpty() ? -1 : stack.pop();
                    System.out.println(result);
                    break;
                }

                case "size" : {
                    result = stack.size();
                    System.out.println(result);
                    break;
                }

                case "empty" : {
                    result = stack.isEmpty() ? 1 : 0;
                    System.out.println(result);
                    break;
                }

                case "top" : {
                    result = stack.isEmpty() ? -1 : stack.peek();
                    System.out.println(result);
                    break;
                }
            }
        }
    }
}
