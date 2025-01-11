import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        String answer = "";
        for (int i = 0; i < num; i++) {
            String str = sc.nextLine();
            answer = String.valueOf(str.charAt(0)).concat(String.valueOf(str.charAt(str.length() - 1)));
            System.out.println(answer);
        }
    }
}