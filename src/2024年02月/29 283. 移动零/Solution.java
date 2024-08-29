class Solution {
    public void moveZeroes(int[] nums) {
        for (int i = 0, j = 0; j < nums.length; i++, j++) {
            while (j < nums.length && nums[j] == 0) {
                j++;
            }
            if (j < nums.length) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
    }
}