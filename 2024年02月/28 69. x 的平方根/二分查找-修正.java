class Solution {
    public int mySqrt(int x) {
        int l = 0, r = x;
        while (l <= r) {
            int mid = l + ((r - l) / 2);
            long y = (long) mid * mid;
            if (y > x) {
                r = mid - 1;
            } else if (y < x) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return r;
    }
}