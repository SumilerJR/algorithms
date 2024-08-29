import java.util.Arrays;

class Solution {
    int[] v;

    public int minScoreTriangulation(int[] values) {
        this.v = values;
        int len = values.length;
        int[][] dp = new int[len][len];
        for (int i = len - 3; i >= 0; i--) {
            for (int j = i + 2; j < len; j++) {
                int res = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    res = Math.min(res, dp[i][k] + dp[k][j] + v[i] * v[k] * v[j]);
                }
                dp[i][j] = res;
            }
        }
        return dp[0][len - 1];
    }
}