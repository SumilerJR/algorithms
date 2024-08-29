class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int i = 0, ans = 0, length = nums.length;
        while (i < length) {
            if (nums[i] % 2 == 0 && nums[i] <= threshold) {
                int l = i;
                i++;
                while (i < length && nums[i] % 2 != nums[i - 1] % 2 && nums[i] <= threshold) {
                    i++;
                }
                ans = Math.max(ans, i - l);
            } else {
                i++;
            }
        }
        return ans;
    }
}