class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1; // []
        int mid = 0;
        while (l <= r) {
            mid = l + ((r - l) / 2);
            if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        // 分别处理如下四种情况
        // 目标值在数组所有元素之前 [0, -1]
        // 目标值等于数组中某一个元素 return middle;
        // 目标值插入数组中的位置 [left, right]，return right + 1
        // 目标值在数组所有元素之后的情况 [left, right]， 因为是右闭区间，所以 return right + 1
        return r + 1;
    }
}