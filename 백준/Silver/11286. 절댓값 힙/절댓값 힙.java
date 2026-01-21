import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((num1, num2) -> {
            int absNum1 = Math.abs(num1);
            int absNum2 = Math.abs(num2);

            if (absNum1 != absNum2) {
                return absNum1 - absNum2;  
            }
                
            return num1 - num2;                          
        });

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                if (pq.isEmpty()) {
                    sb.append(0).append('\n');
                } else {
                    sb.append(pq.poll()).append('\n');
                } 
            } else {
                pq.offer(x);
            }
        }

        System.out.print(sb);
    }
}
