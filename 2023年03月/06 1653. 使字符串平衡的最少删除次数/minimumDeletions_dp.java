class Solution {
    public int minimumDeletions(String s) {
        int ans = 0, count_b = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'b') {
                count_b++;
            } else {
                ans = Math.min(ans + 1, count_b);
            }
        }
        return ans;
    }
}