//执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
//内存消耗：39.3 MB, 在所有 Java 提交中击败了100.00%的用户
// 记录第一次打周赛 第一题
class Solution {
    public char repeatedCharacter(String s) {
        boolean[] map = new boolean[26];
//        Arrays.fill(map, -1);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map[ch - 'a'])
                return ch;
            else
                map[ch - 'a'] = true;
        }
        return 'a';
    }
}
