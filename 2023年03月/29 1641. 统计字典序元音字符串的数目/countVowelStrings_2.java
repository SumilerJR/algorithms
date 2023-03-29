import java.util.Arrays;

class Solution {
    public int countVowelStrings(int n) {
        int[] dp = new int[5];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < 5; j++) {
                dp[j] += dp[j - 1];
            }
        }
        int ans = 0;
        for (int i = 0; i < 5; i++)
            ans += dp[i];
        return ans;
    }
}