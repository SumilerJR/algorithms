class Solution {
    public boolean halvesAreAlike(String s) {
        int mid = s.length() / 2;
        int left = 0, right = 0;
        String check = "aeiouAEIOU";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (check.indexOf(ch) != -1) {
                if (i < mid) left++;
                else right++;
            }
        }
        return left == right;
    }
}