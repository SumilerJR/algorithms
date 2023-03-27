// 时间3 ms击败77.32%
// 内存39.5 MB 击败70.10%
class Solution {
    public int countSubstrings(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        char[] arrS = s.toCharArray();
        char[] arrT = t.toCharArray();
        int ans = 0;
        for (int i = 0; i < sLen; i++) {
            for (int j = 0; j < tLen; j++) {
                int flag = 0;// 标记变量
                for (int k = 0; k < Math.min(sLen - i, tLen - j); k++) {
                    if (arrS[i + k] != arrT[j + k]) {
                        flag++;// 出现不相等的字串字符，标记+1
                    }
                    if (flag == 1) {
                        ans++;// 差一个字符的子串，答案+1
                    }
                    if (flag > 1) {
                        break;// 相差字符超过一个了，跳过该字串的循环比较
                    }
                }
            }
        }
        return ans;
    }
}