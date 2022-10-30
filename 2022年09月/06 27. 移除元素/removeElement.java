//执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
//内存消耗：40.3 MB, 在所有 Java 提交中击败了21.35%的用户
class Solution {
    public int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val)
                continue;
            nums[j++] = nums[i];
        }
        return j;
    }
}