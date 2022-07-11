//执行用时：8 ms, 在所有 Java 提交中击败了65.81%的用户
//内存消耗：42.6 MB, 在所有 Java 提交中击败了34.26%的用户
// - 滑动窗口
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s.length() < p.length())
            return list;
        int[] map_s = new int[26];
        int[] map_p = new int[26];
        int left = 0, right = p.length();
        for (int i = 0; i < p.length(); i++) {
            map_s[s.charAt(i) - 'a']++;
            map_p[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(map_s, map_p))
            list.add(left);
        while (right < s.length()) {
            map_s[s.charAt(right++) - 'a']++;//滑动窗口移动
            map_s[s.charAt(left++) - 'a']--;
            if (Arrays.equals(map_s, map_p))//比较两个数组是否相等
                list.add(left);
        }
        return list;
    }
}
