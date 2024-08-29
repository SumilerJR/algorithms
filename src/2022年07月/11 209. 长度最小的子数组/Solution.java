//执行用时：1 ms, 在所有 Java 提交中击败了99.97%的用户
//内存消耗：48.9 MB, 在所有 Java 提交中击败了9.47%的用户
// - 滑动窗口
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int length = nums.length;
        int minLength = Integer.MAX_VALUE;
        int left = 0, right = 0, sum = 0;
        while (right < length) {
            sum += nums[right++];
            while (sum >= target) {
                minLength = Math.min(minLength, right - left);
                sum -= nums[left++];
            }
        }
        return minLength > length ? 0 : minLength;
    }
}
//执行用时：1 ms, 在所有 Java 提交中击败了99.97%的用户
//内存消耗：49 MB, 在所有 Java 提交中击败了6.32%的用户
// - 前缀和 + 滑动窗口
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int length = nums.length;
        int minLength = 0;
        for (int i = 1; i < length; i++)
            nums[i] += nums[i - 1];
        int left = -1, right = 0;
        while (right < length && nums[right] < target)
            right++;
        if(right < length)
            minLength = right - left;
        while (right < length) {
            while (left < right && nums[right] - nums[left + 1] >= target) {
                left++;
                minLength = right - left;
            }
            left++;
            right++;
        }
        return minLength;
    }
}
