//执行用时：2 ms, 在所有 Java 提交中击败了93.84%的用户
//内存消耗：40 MB, 在所有 Java 提交中击败了94.79%的用户
class Solution {
    public String orderlyQueue(String s, int k) {
        if (s.length() <= 1)
            return s;
        if (k == 1) {
            StringBuilder result = new StringBuilder(s);
            StringBuilder temp = new StringBuilder(s);
            for (int i = 0; i < s.length(); i++) {
                temp.append(temp.charAt(0));
                temp.deleteCharAt(0);
                if (result.compareTo(temp) > 0) {
                    result.delete(0, result.length());
                    result.append(temp);
                }
            }
            return result.toString();
        }
        else {
            int[] map = new int[26];
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                map[s.charAt(i) - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < map[i]; j++)
                    result.append((char)(i + 'a'));
            }
            return result.toString();
        }
    }
}