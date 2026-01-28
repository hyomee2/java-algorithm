import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int temp;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1 - i ; j++) {  // 무조건 정렬된 맨 뒷부분은 제외
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        for (int i = 1; i < N + 1; i++) {
            sb.append(arr[i]).append("\n");
        }

        System.out.println(sb);
    }
}