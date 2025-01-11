import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        long sum = Arrays.stream(input.split(" "))
                .mapToLong(Long::parseLong)
                .sum();
        System.out.println(sum);
    }
}