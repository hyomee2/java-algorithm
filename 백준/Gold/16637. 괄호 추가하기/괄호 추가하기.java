import java.io.*;

public class Main {
    static int N;
    static String expression;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        expression = br.readLine();

        dfs(0, expression.charAt(0) - '0');

        System.out.println(max);
    }

    static void dfs(int index, int result) {
        // 모든 연산 수행했을 때 최댓값 갱신
        if (index >= N - 1) {
            max = Math.max(max, result);
            return;
        }

        // 현재 연산자와 다음 숫자 가져오기
        char operator = expression.charAt(index + 1);
        int nextNum = expression.charAt(index + 2) - '0';

        // 1. 괄호없이 현재 연산 수행
        int calc1 = calculate(result, operator, nextNum);
        dfs(index + 2, calc1);

        // 2. 괄호 있는 경우 (index + 3이 N을 넘지 않을 때만 가능)
        if (index + 3 < N) {
            char nextOperator = expression.charAt(index + 3);
            int nextNextNum = expression.charAt(index + 4) - '0';

            // 괄호 연산 먼저 수행
            int calc2 = calculate(nextNum, nextOperator, nextNextNum);
            // 기존 결과와 괄호 연산된 값으로 연산
            int finalCalc = calculate(result, operator, calc2);

            dfs(index + 4, finalCalc);
        }
    }

    static int calculate(int a, char operator, int b) {
        if (operator == '+') return a + b;
        if (operator == '-') return a - b;
        return a * b;
    }
}