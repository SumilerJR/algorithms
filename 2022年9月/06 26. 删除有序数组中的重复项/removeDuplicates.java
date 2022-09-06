//执行用时：1 ms, 在所有 Java 提交中击败了22.54%的用户
//内存消耗：42.9 MB, 在所有 Java 提交中击败了80.37%的用户
class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            while (i < nums.length - 1 && nums[i] == nums[i + 1])
                i++;
            nums[j++] = nums[i];
        }
        return j;
    }
}