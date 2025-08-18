class Solution {
    public int solution(int[] arr) {
        return lcm(0, arr[0], arr);
    }
    
    public int lcm(int index, int value, int[] array) {
        if (index == array.length) {
            return value;
        }
        
        int next = array[index];
        int mul = value * next;
        int lcm = mul / gcd(value, next);
        
        return lcm(index + 1, lcm, array);
    }
    
    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}