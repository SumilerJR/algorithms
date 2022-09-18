class Solution {
    public int longestContinuousSubstring(String s) {
        int ans = 1;
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] - chars[i - 1] == 1) {
                int j = i;
                while (j < chars.length && chars[j] - chars[j - 1] == 1) {
                    j++;
                }
                ans = Math.max(ans, j - i + 1);
            }
        }
        return ans;
    }
}