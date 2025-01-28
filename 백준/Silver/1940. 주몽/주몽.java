import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[m];
        int answer = 0;
        int left = 0;
        int right = m - 1;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        while (left < right) {
            if (nums[left] + nums[right] == n) {
                answer++;
                left++;
                right--;
            } else if (nums[left] + nums[right] > n) {
                right--;
            } else {   // nums[left] + nums[right] < n
                left++;
            }
        }

        System.out.println(answer);
    }
}