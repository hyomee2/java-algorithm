import java.io.*;
import java.util.*;

public class Main {
    static int[][] array;
    static int[] numOfPaper = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        array = new int[N][N];

        // array 만들기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        split(0, 0, N - 1, N - 1);
        sb.append(numOfPaper[0]).append("\n")
                .append(numOfPaper[1]).append("\n").append(numOfPaper[2]);
        System.out.println(sb);
    }

    // 분할
    public static int check(int startR, int startC, int endR, int endC) {
        int num = array[startR][startC];
        for (int i = startR; i <= endR; i++) {
            for (int j = startC; j <= endC; j++) {
                if (array[i][j] != num) {
                    return 2;
                }
            }
        }
        return num;
    }

    public static void split(int startR, int startC, int endR, int endC) {
        int result = check(startR, startC, endR, endC);
        if (result != 2) {
            numOfPaper[result + 1]++;
            return;
        }

        int size = (endC - startC + 1) / 3;
        int firstR = startR + size;
        int firstC = startC + size;
        int secondR = startR + 2 * size;
        int secondC = startC + 2 * size;

        split(startR, startC, firstR - 1, firstC - 1);
        split(startR, firstC, firstR - 1, secondC - 1);
        split(startR, secondC, firstR - 1, endC);

        split(firstR, startC, secondR - 1, firstC - 1);
        split(firstR, firstC, secondR - 1, secondC - 1);
        split(firstR, secondC, secondR - 1, endC);

        split(secondR, startC, endR, firstC - 1);
        split(secondR, firstC, endR, secondC - 1);
        split(secondR, secondC, endR, endC);
    }
}