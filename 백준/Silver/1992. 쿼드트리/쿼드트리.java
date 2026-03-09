import java.io.*;

public class Main {
    static int[][] table;
    static StringBuilder sb;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        table = new int[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                table[i][j] = Integer.parseInt(str.charAt(j) + "");
            }
        }

        split(0, 0, N);
        System.out.println(sb);
    }

    public static void split(int startRow, int startCol, int size) {
        int result = check(startRow, startCol, size);
        if (result != -1) {
            sb.append(result);
            return;
        }

        int half = size / 2;
        sb.append("(");

        split(startRow, startCol, half);
        split(startRow, startCol + half, half);
        split(startRow + half, startCol, half);
        split(startRow + half, startCol + half, half);

        sb.append(")");
    }

    public static int check(int startRow, int startCol, int size) {
        int color = table[startRow][startCol];
        for (int i = startRow; i < startRow + size; i++) {
            for (int j = startCol; j < startCol + size; j++) {
                if (color != table[i][j]) {
                    return -1;
                }
            }
        }
        return color;
    }
}