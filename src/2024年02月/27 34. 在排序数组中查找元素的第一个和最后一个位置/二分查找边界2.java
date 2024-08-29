class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length;
        int low = -1, high = -1;
        // 找左边界
        while (l < r) {
            int mid = l + ((r - l) / 2);
            if (nums[mid] == target) {
                low = mid; // 更新左边界
                r = mid; // 将右区间缩小到新的二分区域，进行更左边的二分查找（这里mid是右开区间）
            } else if (nums[mid] > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        l = 0;
        r = nums.length;
        // 找右边界
        while (l < r) {
            int mid = l + ((r - l) / 2);
            if (nums[mid] == target) {
                high = mid; // 更新右边界
                l = mid + 1; // 将左区间缩小到新的二分区域，进行更右边的二分查找
            } else if (nums[mid] > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return new int[] { low, high };
    }
}