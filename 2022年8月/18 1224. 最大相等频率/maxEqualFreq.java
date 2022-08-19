//执行用时：7 ms, 在所有 Java 提交中击败了84.44%的用户
//内存消耗：51.4 MB, 在所有 Java 提交中击败了33.33%的用户
class Solution {
    public int maxEqualFreq(int[] nums) {
        int[] count = new int[100010], sum = new int[100010];
        int max = 0,ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int k = nums[i];
            int cur = ++count[k], len = i + 1;
            sum[cur]++;
            sum[cur - 1]--;
            max = Math.max(max, cur);
            if (max == 1)
                ans = len;
            else if (max * sum[max] + 1 == len)
                ans = len;
            else if ((max - 1) * (sum[max - 1] + 1) + 1 == len)
                ans = len;
        }
        return ans;
    }
}
