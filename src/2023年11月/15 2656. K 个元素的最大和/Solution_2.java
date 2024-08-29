class Solution {
    public int maximizeSum(int[] nums, int k) {
        int ans = 0;
        for (int m : nums) {
            ans = Math.max(ans, m); // 取最大值
        }
        return ans * k + (k - 1) * k / 2; // 找规律套公式
    }
}