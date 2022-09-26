//执行用时：2 ms, 在所有 Java 提交中击败了100.00%的用户
//内存消耗：49.1 MB, 在所有 Java 提交中击败了100.00%的用户
class Solution {
    public int longestSubarray(int[] nums) {
        int max = Integer.MIN_VALUE, k = Integer.MIN_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            k = Math.max(k, nums[i]);
        }
        for (int i = 0; i < n; i++)  {
            if(nums[i] == k) {
                int j = 0;
                while (i < n && nums[i] == k ) {
                    i++;
                    j++;
                }
                max = Math.max(max, j);
            }
        }
        return max;
    }
}
