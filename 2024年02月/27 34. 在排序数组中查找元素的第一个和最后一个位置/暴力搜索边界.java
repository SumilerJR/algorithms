class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length; // [)
        int mid = 0;
        while (l < r) {
            mid = l + ((r - l) / 2);
            if (nums[mid] > target) {
                r = mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                // 找到目标后直接往左和往右扫描，得到答案。（有点呆）
                int ll = mid, rr = mid;
                while (ll >= 0 && nums[ll] == nums[mid]) {
                    ll--;
                }
                while (rr < nums.length && nums[rr] == nums[mid]) {
                    rr++;
                }
                return new int[] { ll + 1, rr - 1 };
            }
        }
        // 没有找到目标则返回-1，-1
        return new int[] { -1, -1 };
    }
}