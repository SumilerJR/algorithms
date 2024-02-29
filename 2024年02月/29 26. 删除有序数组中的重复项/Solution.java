class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
            nums[count++] = nums[i];
        }
        return count;
    }
}