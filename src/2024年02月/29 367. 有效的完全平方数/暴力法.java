class Solution {
    public boolean isPerfectSquare(int num) {
        for (long i = 1; i <= num; i++) {
            long x = i * i;
            if (x == num) {
                return true;
            }
        }
        return false;
    }
}