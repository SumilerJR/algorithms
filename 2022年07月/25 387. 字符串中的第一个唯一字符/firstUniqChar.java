//执行用时：6 ms, 在所有 Java 提交中击败了74.05%的用户
//内存消耗：41.9 MB, 在所有 Java 提交中击败了47.10%的用户
class Solution {
    public int firstUniqChar(String s) {
        int[] map = new int[26];
        int index = Integer.MAX_VALUE;
        Arrays.fill(map, -1);
        for (int i = 0; i < s.length(); i++) {
            int n = s.charAt(i) - 'a';
            if (map[n] == -1)
                map[n] = i;
            else if (map[n] >= 0)
                map[n] = -2;
        }
        for (int i = 0; i < 26; i++) {
            if (map[i] >= 0 && map[i] < index)
                index = map[i];
        }
        return index == Integer.MAX_VALUE ? -1 : index;
    }
}
