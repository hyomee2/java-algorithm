import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        // Collections 사용을 위해 int -> Integer
        Integer[] nums = Arrays.stream(numbers).boxed().toArray(Integer[]::new);
        Arrays.sort(nums, Collections.reverseOrder()); 
        return nums[0] * nums[1];
    }
}
