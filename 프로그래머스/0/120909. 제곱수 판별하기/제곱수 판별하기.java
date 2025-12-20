class Solution {
    public int solution(int n) {
        double sqrt = Math.sqrt(n);
        int answer = (sqrt == (int) sqrt) ? 1 : 2;
        return answer;
    }
}