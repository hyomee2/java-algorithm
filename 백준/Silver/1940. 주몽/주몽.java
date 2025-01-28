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
        int right = m;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        // 고유한 재료의 값이 m 이하인 것만 고려하면 됨. right 인덱스 설정
        for (int i = m - 1; i >= 0; i--) {
            if (nums[i] <= n) {
                right = i;
                break;
            }
        }

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