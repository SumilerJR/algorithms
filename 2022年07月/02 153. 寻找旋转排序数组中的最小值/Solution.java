// 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
// 内存消耗：41.5 MB, 在所有 Java 提交中击败了5.29%的用户
class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right])
                right = mid;
            else
                left = mid + 1;
        }
        return nums[left];
    }
}
