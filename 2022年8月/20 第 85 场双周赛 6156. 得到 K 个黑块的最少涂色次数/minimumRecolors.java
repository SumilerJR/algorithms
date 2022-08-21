// - 暴力滑动窗口
class Solution {
    public int minimumRecolors(String blocks, int k) {
        int left = 0, right, max = 0;
        for (right = 0; right < k; right++) {
            char ch = blocks.charAt(right);
            if (ch == 'B')
                max++;
        }
        int temp = max;
        while (right < blocks.length()) {
            char ch1 = blocks.charAt(right);
            char ch2 = blocks.charAt(left);
            if (ch1 == 'B')
                temp++;
            if (ch2 == 'B')
                temp--;
            max = Math.max(max, temp);
            right++;
            left++;
        }
        return k - max;
    }
}