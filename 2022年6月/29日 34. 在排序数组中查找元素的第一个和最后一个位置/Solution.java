//执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
//内存消耗：44.7 MB, 在所有 Java 提交中击败了26.61%的用户
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int length = nums.length;
        int left = 0, right = length - 1;
        int[] scope = {-1, -1};
        if (length == 0)
            return scope;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid;
        }
        if (nums[left] != target)
            return scope;
        scope[0] = left;
        right = length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target)
                left = mid + 1;
            else
                right = mid;
        }
        scope[1] = left - 1;
        return scope;
    }
}
