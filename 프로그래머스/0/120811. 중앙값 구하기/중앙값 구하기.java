import java.util.*;

class Solution {
    public int solution(int[] array) {
        Arrays.sort(array);
        
        int length = array.length;
        
        return array[length / 2];
    }
}