import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String temp, s1, s2;
        int sum1, sum2;
        boolean flag;

        String[] arr = new String[N + 1];
        for (int i = 1; i < N + 1; i++) {
            arr[i] = br.readLine();
        }

        for (int k = 0; k < N + 1; k++) {
            for (int i = 1; i < N; i++) {
                s1 = arr[i];
                s2 = arr[i + 1];
                flag = false;

                // 길이 비교
                if (s1.length() > s2.length()) {
                    flag = true;
                }

                // 합 비교
                else if (s1.length() == s2.length()) {
                    sum1 = summation(s1);
                    sum2 = summation(s2);

                    if (sum1 > sum2) {
                        flag = true;
                    }

                    // 사전식 비교
                    else if (sum1 == sum2) {
                        if (s1.compareTo(s2) > 0) {
                            flag = true;
                        }
                    }
                }

                if (flag) {
                    temp = s1;
                    arr[i] = s2;
                    arr[i + 1] = temp;
                }
            }
        }

        for (int i = 1; i < N + 1; i++) {
            sb.append(arr[i]).append("\n");
        }

        System.out.println(sb);
    }

    private static int summation(String s) {
        int sum = 0;
        for (int j = 0; j < s.length(); j++) {
            char temp1 = s.charAt(j);
            if (temp1 >= '0' && temp1 <= '9') {
                sum += (temp1 - '0');
            }
        }
        return sum;
    }
}