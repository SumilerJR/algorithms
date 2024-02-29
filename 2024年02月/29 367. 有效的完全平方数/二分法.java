class Solution {
    public boolean isPerfectSquare(int num) {
        int l = 1, r = num;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            // (long long)(middle * middle)是把乘法计算的结果转换为long long，但是middle *
            // middle仍然按int类型计算，所以越界
            // (long long)middle * middle是先把第一个middle转换为long
            // long，然后计算*，第二个middle也跟着提升为longlong，这样就是long long类型的乘积，不会越界
            long x = (long) mid * mid;
            if (x > num) {
                r = mid - 1;
            } else if (x < num) {
                l = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}