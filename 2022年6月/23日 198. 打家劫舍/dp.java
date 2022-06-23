// - 数组记录 递推公式1
//执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
//内存消耗：39.1 MB, 在所有 Java 提交中击败了10.67%的用户
class Solution {
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 1)
            return nums[0];
        if (length == 2)
            return Math.max(nums[0], nums[1]);
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = nums[0] + nums[2];
        int max = Math.max(dp[1], dp[2]);
        for (int i = 3; i < length; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3]) + nums[i];
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}

// - 数组记录 递推公式2
//执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
//内存消耗：39.3 MB, 在所有 Java 提交中击败了5.02%的用户
class Solution {
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 1)
            return nums[0];
        if (length == 2)
            return Math.max(nums[0], nums[1]);
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);//这里初始化为偷到第二个房屋时的最大金额
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);//偷到第i个房屋时，每次取最大值
        }
        return dp[length - 1];//偷完之后取最后的值即可
    }
}


// - 常量级变量 递推公式2
//执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
//内存消耗：39.2 MB, 在所有 Java 提交中击败了5.02%的用户
class Solution {
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 1)
            return nums[0];
        if (length == 2)
            return Math.max(nums[0], nums[1]);
        int a = nums[0];
        int b = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            int temp = Math.max(nums[i] + a, b);
            a = b;
            b = temp;
        }
        return b;
    }
}
