// 做老题，感觉比以前好懂多了，很快搞明白了以前看得一脸懵逼的地方。
// 滑动窗口

// 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
// 内存消耗：41.6 MB, 在所有 Java 提交中击败了33.31%的用户

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[127];//记录字符上一次出现的位置
        Arrays.fill(map, -1);
        int left = 0, maxLen = 0;//左臂和最大长度
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // if(map[ch] != -1){
            //     left = Math.max(left, map[ch] + 1);//不用加判断了，取了max效果是一样的
            // }
            left = Math.max(left, map[ch] + 1);
            map[ch] = i;
            maxLen = Math.max(maxLen, i - left + 1);
        }
        return maxLen;
    }
}