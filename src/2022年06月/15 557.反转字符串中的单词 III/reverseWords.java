// 逐个原地翻转
// 转为字符数组（这里不算原地了），然后每次找空格的位置进行逐个单词的翻转


// 执行用时：3 ms, 在所有 Java 提交中击败了90.94%的用户
// 内存消耗：41.7 MB, 在所有 Java 提交中击败了66.38%的用户

class Solution {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int length = s.length();
        int left = 0, right = s.indexOf(' ');
        while(left < right) {
            reverse(chars, left, right - 1);
            left = right + 1;
            right = s.indexOf(' ', left);
        }
        reverse(chars, left, length - 1);
        return new String(chars);
    }

    public void reverse(char[] chars, int left, int right) {
        while(left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}
// StringBuilder拼接 

// 执行用时：9 ms, 在所有 Java 提交中击败了39.32%的用户
// 内存消耗：42.3 MB, 在所有 Java 提交中击败了9.45%的用户

class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == ' ') {
                sb.append(temp.reverse() + " ");
                temp.delete(0, temp.length());
            }
            else
                temp.append(ch);

        }
        sb.append(temp.reverse());
        return sb.toString();
    }
}