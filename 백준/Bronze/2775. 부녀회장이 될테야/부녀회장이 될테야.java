import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int[][] numOfResidents = new int[15][15];

        for (int i = 1; i <= 14; i++){
            numOfResidents[i][1] = 1;
            numOfResidents[0][i] = i;
        }

        for (int i = 1; i <= 14; i++) {
            for (int j = 2; j <= 14; j++) {
                numOfResidents[i][j] = numOfResidents[i][j - 1] + numOfResidents[i - 1][j];
            }
        }

        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            sb.append(numOfResidents[k][n]).append("\n");
        }

        System.out.println(sb);
    }
}