import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//执行用时：34 ms, 在所有 Java 提交中击败了15.28%的用户
//内存消耗：41.8 MB, 在所有 Java 提交中击败了30.55%的用户
//对前一个数字排序
class Solution {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        return dp[n - 1];
    }
}


//执行用时：8 ms, 在所有 Java 提交中击败了98.18%的用户
//内存消耗：41.4 MB, 在所有 Java 提交中击败了78.53%的用户
//对后一个数字排序
class Solution {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int ans = 1, pre = pairs[0][1];
        for (int i = 1; i < n; i++) {
            if (pairs[i][0] > pre) {
                ans++;
                pre = pairs[i][1];
            }
        }
        return ans;
    }
}