class Solution {
    public int[] solution(int brown, int yellow) {
        for (int i = 1; i <= Math.sqrt(yellow); i++) {
            if (yellow % i == 0) {
                int yellowWidth = yellow / i;
                int yellowHeight = i;
                
                if ((yellowWidth + yellowHeight) * 2 + 4 == brown) {
                    return new int[]{yellowWidth + 2, yellowHeight + 2};
                }
            }
        }
        
        return new int[]{-1, -1};
    }
}