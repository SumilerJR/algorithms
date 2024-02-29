class Solution {
    public int mySqrt(int x) {
        long l = 0, r = x;
        while (l <= r) {
            long mid = l + ((r - l) / 2);
            long y = mid * mid;
            if (y > x) {
                r = mid - 1;
            } else if (y < x) {
                l = mid + 1;
            } else {
                return (int) mid;
            }
        }
        return (int) r;
    }
}