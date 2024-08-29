class Solution {
    public int[] searchRange(int[] nums, int target) {
        int leftBorder = getLeftBorder(nums, target);
        int rightBorder = getRightBorder(nums, target);
        // 情况一
        if (leftBorder == -2 || rightBorder == -2)
            return new int[] { -1, -1 };
        // 情况三
        if (rightBorder > leftBorder)
            return new int[] { leftBorder, rightBorder - 1 };
        // 情况二
        return new int[] { -1, -1 };

    }

    // 获取左边界是通过不断收缩右边界得到的
    public int getLeftBorder(int[] nums, int target) {
        int l = 0, r = nums.length; // [)
        int leftBorder = -2;
        while (l < r) {
            int mid = l + ((r - l) / 2);
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
                leftBorder = r;
            }
        }
        return leftBorder;
    }

    // 获取右边界是通过不断收缩左边界得到的
    public int getRightBorder(int[] nums, int target) {
        int l = 0, r = nums.length; // [)
        int rightBorder = -2;
        while (l < r) {
            int mid = l + ((r - l) / 2);
            if (nums[mid] > target) {
                r = mid;
            } else {
                l = mid + 1;
                rightBorder = l;
            }
        }
        return rightBorder;
    }
}