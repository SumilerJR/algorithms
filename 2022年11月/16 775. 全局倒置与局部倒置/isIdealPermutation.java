class Solution {
    public boolean isIdealPermutation(int[] nums) {
        int max = nums[0], n = nums.length;
        for (int i = 2; i < n; i++) {
            if (max > nums[i])
                return false;
            max = Math.max(max, nums[i - 1]);
        }
        return true;
    }
}