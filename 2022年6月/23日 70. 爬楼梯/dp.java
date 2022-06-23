//常量空间
//执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
//内存消耗：38.2 MB, 在所有 Java 提交中击败了55.84%的用户
class Solution {
    public int climbStairs(int n) {
        if (n == 1)
            return 1;
        int a = 1, b = 2;
        for (int i = 3; i <= n; i++) {
            b = a + b;
            a = b - a;
        }
        return b;
    }
}

//dp数组
//执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
//内存消耗：38.6 MB, 在所有 Java 提交中击败了5.30%的用户
class Solution {
    public int climbStairs(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }
}
