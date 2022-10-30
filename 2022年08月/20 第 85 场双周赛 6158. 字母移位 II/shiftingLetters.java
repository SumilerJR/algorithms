// 执行用时：7 ms, 在所有 Java 提交中击败了100.00%的用户
// 内存消耗：80.9 MB, 在所有 Java 提交中击败了100.00%的用户
// - 差分数组
class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        char[] chars = s.toCharArray();
        int[] map = new int[s.length() + 1];
        for (int i = 0; i < shifts.length; i++) {
            if (shifts[i][2] == 1) {
                map[shifts[i][0]]++;
                map[shifts[i][1] + 1]--;
            } else {
                map[shifts[i][0]]--;
                map[shifts[i][1] + 1]++;
            }
//            map[shifts[i][0]] += shifts[i][2] == 0 ? -1 : 1;
//            map[shifts[i][1] + 1] -= shifts[i][2] == 0 ? -1 : 1;
        }
        for (int i = 1; i < map.length; i++)
            map[i] += map[i - 1];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (((chars[i] - 'a' + map[i]) % 26 + 26) % 26 + 'a');
        }
        return new String(chars);
    }
}